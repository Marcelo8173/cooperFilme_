package com.eureka.cooperfilme.application.status.factory;

import com.eureka.cooperfilme.domain.scripts.changeStatus.StatusChangeCheck;
import com.eureka.cooperfilme.domain.user.enuns.UserRoles;

public interface StatusTransitionCheckerFactory {
    StatusChangeCheck createChecker(UserRoles role);
}
