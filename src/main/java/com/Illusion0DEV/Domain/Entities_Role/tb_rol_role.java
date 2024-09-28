package com.Illusion0DEV.Domain.Entities_Role;

import org.springframework.security.core.GrantedAuthority;

public enum tb_rol_role  implements GrantedAuthority {

    ROLE_ADMIN, ROLE_USER;

    @Override
    public String getAuthority() {
        return name();
    }
}
