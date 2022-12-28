package uz.isft.applibary.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class SignDTO {

//    @NotBlank(message = "MUST_NOT_BE_BLANK_PHONE_NUMBER")
    private String phoneNumber;

//    @NotBlank(message = "MUST_NOT_BE_BLANK_PASSWORD")
    private String password;
}
