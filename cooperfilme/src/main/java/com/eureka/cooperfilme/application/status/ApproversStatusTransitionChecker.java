package com.eureka.cooperfilme.application.status;

import com.eureka.cooperfilme.domain.scripts.changeStatus.StatusChangeCheck;
import com.eureka.cooperfilme.domain.scripts.enuns.ScriptsStatus;

public class ApproversStatusTransitionChecker implements StatusChangeCheck {
    @Override
    public boolean canChangeStatus(ScriptsStatus currentStatus, String nextStatus) {
        switch (currentStatus) {
            case AGUARDANDO_REVISAO:
                return nextStatus.equals(ScriptsStatus.EM_REVISAO.name());
            case EM_REVISAO:
                return nextStatus.equals(ScriptsStatus.AGUARDANDO_APROVACAO.name());
            default:
                return false;
        }
    }
}
