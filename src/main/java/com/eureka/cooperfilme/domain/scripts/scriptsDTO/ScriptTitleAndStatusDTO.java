package com.eureka.cooperfilme.domain.scripts.scriptsDTO;

public class ScriptTitleAndStatusDTO {
    private String status;
    private String title;

    public ScriptTitleAndStatusDTO(String status, String title) {
        this.status = status;
        this.title = title;
    }

    // Getters and setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}