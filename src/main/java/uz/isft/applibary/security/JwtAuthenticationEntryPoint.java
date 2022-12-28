package uz.isft.applibary.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import uz.isft.applibary.payload.ApiResult;
import uz.isft.applibary.payload.ErrorData;
import uz.isft.applibary.util.RestConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException {
        log.error("Responding with unauthorized error. URL -  {}, Message - {}", httpServletRequest.getRequestURI(), e.getMessage());
        ApiResult<ErrorData> errorDataApiResult = ApiResult.errorResponse("Forbidden", 403);
        httpServletResponse.getWriter().write(RestConstants.objectMapper.writeValueAsString(errorDataApiResult));
        httpServletResponse.setStatus(403);
        httpServletResponse.setContentType("application/json");
    }

}
