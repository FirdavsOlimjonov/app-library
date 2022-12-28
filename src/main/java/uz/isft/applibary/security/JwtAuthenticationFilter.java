package uz.isft.applibary.security;


import javax.persistence.*;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import uz.isft.applibary.entity.User;
import uz.isft.applibary.service.AuthService;
import uz.isft.applibary.util.RestConstants;

import java.io.IOException;
import java.util.UUID;

@Slf4j
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;
    private final AuthService authService;

    public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider
            , @Lazy AuthService authService) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.authService = authService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {

        try {
            setUserPrincipalIfAllOk(httpServletRequest);
        } catch (Exception e) {
            log.error("Error in JwtAuthenticationFilter setUserPrincipalIfAllOk method: ", e);
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private void setUserPrincipalIfAllOk(HttpServletRequest request) {
        String authorization = request.getHeader(RestConstants.AUTHENTICATION_HEADER);

        if (authorization != null) {
            User user = getUserFromBearerToken(authorization);
            if (user != null) {
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(user, user.getAuthorities(),null);
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
    }


    public User getUserFromBearerToken(String token) {
        try {
            token = token.substring("Bearer".length()).trim();
            if (jwtTokenProvider.validToken(token, true)) {
                String userId = jwtTokenProvider.getUserIdFromToken(token, true);
                return authService.getUserById(UUID.fromString(userId)).orElseThrow(RuntimeException::new);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
