package com.eureka.cooperfilme.application.status;

import com.eureka.cooperfilme.domain.scripts.changeStatus.StatusChangeCheck;
import com.eureka.cooperfilme.domain.scripts.enuns.ScriptsStatus;

public class AnalystStatusTransitionChecker implements StatusChangeCheck {
    @Override
    public boolean canChangeStatus(ScriptsStatus currentStatus, String nextStatus) {
        switch (currentStatus) {
            case AGUARDANDO_ANALISE:
                return nextStatus.equals(ScriptsStatus.EM_ANALISE.name());
            case EM_ANALISE:
                return nextStatus.equals(ScriptsStatus.AGUARDANDO_REVISAO.name()) || nextStatus.equals(ScriptsStatus.RECUSADO.name());
            default:
                return false;
        }
    }
}