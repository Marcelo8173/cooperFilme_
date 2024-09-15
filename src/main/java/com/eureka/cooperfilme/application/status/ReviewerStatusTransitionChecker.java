package com.eureka.cooperfilme.application.status;

import com.eureka.cooperfilme.domain.scripts.changeStatus.StatusChangeCheck;
import com.eureka.cooperfilme.domain.scripts.enuns.ScriptsStatus;

public class ReviewerStatusTransitionChecker implements StatusChangeCheck {
    @Override
    public boolean canChangeStatus(ScriptsStatus currentStatus, String nextStatus) {
        switch (currentStatus) {
            case AGUARDANDO_APROVACAO:
                return nextStatus.equals(ScriptsStatus.EM_APROVACAO.name());
            case EM_APROVACAO:
                return nextStatus.equals(ScriptsStatus.APROVADO.name()) || nextStatus.equals(ScriptsStatus.RECUSADO.name());
            default:
                return false;
        }
    }
}
