package com.eureka.cooperfilme.domain.scripts.changeStatus;

import com.eureka.cooperfilme.domain.scripts.enuns.ScriptsStatus;

public interface StatusChangeCheck {
    boolean canChangeStatus(ScriptsStatus currentStatus, String nextStatus);
}
