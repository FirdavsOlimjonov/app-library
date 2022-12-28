package uz.isft.applibary.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public interface RestConstants {
    ObjectMapper objectMapper = new ObjectMapper();

    String AUTHENTICATION_HEADER = "Authorization";

    String AUTHORIZATION_HEADER = "Authorization";

    String REQUEST_ATTRIBUTE_CURRENT_USER = "User";
    String REQUEST_ATTRIBUTE_CURRENT_USER_ID = "UserId";
    String REQUEST_ATTRIBUTE_CURRENT_USER_PERMISSIONS = "Permissions";

    String[] OPEN_PAGES = {
            "/*",
//            AuthController.AUTH_CONTROLLER_BASE_PATH + "/**",
//            LanguageController.LANGUAGE_CONTROLLER_PATH + "/**"
    };
    String BASE_PATH = "/api/v1/";

}
