package com.eureka.cooperfilme.domain.votation;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_votation")
public class Votation {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private Integer quantity;

    @Column(name = "script_id")
    private UUID scriptId;

    @Column(name = "user_id")
    private UUID userId;


    public Votation() {
    }

    public Votation(UUID id, Integer quantity, UUID scriptId, UUID userId) {
        this.id = id;
        this.quantity = quantity;
        this.scriptId = scriptId;
        this.userId = userId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public UUID getScriptId() {
        return scriptId;
    }

    public void setScriptId(UUID scriptId) {
        this.scriptId = scriptId;
    }
}
