package com.studyjwt.util;


import com.studyjwt.domain.Role;
import com.studyjwt.domain.TokenEntity;
import com.studyjwt.enums.ExpTime;

public interface TokenUtil {
    public TokenEntity create(Role role, ExpTime expTime) throws Exception;

    public boolean verifie(String token);

    public boolean isExpire(String token);

    public String reSign(String token, ExpTime expTime);
}
