package com.eureka.cooperfilme.domain.scripts.enuns;

public enum ScriptsStatus {
    AGUARDANDO_ANALISE(1),
    EM_ANALISE(2),
    AGUARDANDO_REVISAO(3),
    EM_REVISAO(4),
    AGUARDANDO_APROVACAO(5),
    EM_APROVACAO(6),
    APROVADO(7),
    RECUSADO(8);

    private final int statusCode;

    ScriptsStatus(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public static ScriptsStatus fromStatusCode(int statusCode) {
        for (ScriptsStatus status : ScriptsStatus.values()) {
            if (status.getStatusCode() == statusCode) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid status code: " + statusCode);
    }
}
