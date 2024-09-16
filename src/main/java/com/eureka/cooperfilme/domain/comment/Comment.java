package com.eureka.cooperfilme.domain.comment;

import com.eureka.cooperfilme.domain.customer.Customer;
import com.eureka.cooperfilme.domain.scripts.Scripts;
import com.eureka.cooperfilme.domain.user.User;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_comment")
public class Comment {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String comment;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "script_id")
    private UUID scriptId;

    @Column(name = "user_id")
    private UUID userId;

    public Comment() {
    }

    public Comment(UUID id, String comment, UUID scriptId, UUID userId) {
        this.id = id;
        this.comment = comment;
        this.scriptId = scriptId;
        this.userId = userId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public UUID getScriptId() {
        return scriptId;
    }

    public void setScriptId(UUID scriptId) {
        this.scriptId = scriptId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}