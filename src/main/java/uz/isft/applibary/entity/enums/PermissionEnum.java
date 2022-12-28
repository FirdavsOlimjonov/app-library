package uz.isft.applibary.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
@Getter
public enum PermissionEnum implements GrantedAuthority {
    ADD_ROLE(PageEnum.ROLE),
    GET_ROLES(PageEnum.ROLE),
    GET_ROLE(PageEnum.ROLE),
    EDIT_ROLE(PageEnum.ROLE),
    DELETE_ROLE(PageEnum.ROLE),
    ADD_USER(PageEnum.USER),
    GET_USERS(PageEnum.USER),
    GET_USER(PageEnum.USER),
    GET_USERS_FOR_STATION(PageEnum.USER),
    EDIT_USER(PageEnum.USER),
    DELETE_USER(PageEnum.USER);

    private final PageEnum page;

    @Override
    public String getAuthority() {
        return name();
    }
}
