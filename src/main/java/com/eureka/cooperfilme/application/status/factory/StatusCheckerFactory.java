package com.eureka.cooperfilme.application.status.factory;

import com.eureka.cooperfilme.domain.scripts.changeStatus.StatusChangeCheck;
import com.eureka.cooperfilme.domain.user.enuns.UserRoles;
import com.eureka.cooperfilme.application.status.AnalystStatusTransitionChecker;
import com.eureka.cooperfilme.application.status.ReviewerStatusTransitionChecker;
import com.eureka.cooperfilme.application.status.ApproversStatusTransitionChecker;

public class StatusCheckerFactory implements StatusTransitionCheckerFactory {

    @Override
    public StatusChangeCheck createChecker(UserRoles role) {
        switch (role) {
            case ANALISTA:
                return new AnalystStatusTransitionChecker();
            case REVISOR:
                return new ReviewerStatusTransitionChecker();
            case APROVADORES:
                return new ApproversStatusTransitionChecker();
            default:
                throw new IllegalArgumentException("Unknown role: " + role);
        }
    }
}
