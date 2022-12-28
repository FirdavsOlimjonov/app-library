package uz.isft.applibary.service;


import org.springframework.security.core.userdetails.UserDetailsService;
import uz.isft.applibary.entity.User;
import uz.isft.applibary.payload.ApiResult;
import uz.isft.applibary.payload.SignDTO;
import uz.isft.applibary.payload.TokenDTO;

import java.util.Optional;
import java.util.UUID;

public interface AuthService extends UserDetailsService {
    Optional<User> getUserById(UUID id);

    ApiResult<TokenDTO> signIn(SignDTO signDTO);

    ApiResult<TokenDTO> refreshToken(String accessToken, String refreshToken);
}
