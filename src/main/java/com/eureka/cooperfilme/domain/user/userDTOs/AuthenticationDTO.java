package com.eureka.cooperfilme.domain.user.userDTOs;

import com.eureka.cooperfilme.domain.user.enuns.UserRoles;

public record AuthenticationDTO (String email, String password, UserRoles role){
}
