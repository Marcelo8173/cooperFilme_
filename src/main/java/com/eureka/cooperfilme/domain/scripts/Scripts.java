package com.eureka.cooperfilme.domain.scripts;

import com.eureka.cooperfilme.domain.customer.Customer;
import jakarta.persistence.*;
import com.eureka.cooperfilme.domain.scripts.enuns.ScriptsStatus;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_scripts")
public class Scripts {
    @Id
    @GeneratedValue(generator = "UUID")
    UUID id;

    @Column(nullable = false)
    private String title;

//depois alterar
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ScriptsStatus status;

    public Scripts() {
    }

    public Scripts(UUID id, String title, String content, Customer customer, ScriptsStatus status) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.customer = customer;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Customer getClient() {
        return customer;
    }

    public void setClient(Customer client) {
        this.customer = client;
    }

    public ScriptsStatus getStatus() {
        return status;
    }

    public void setStatus(ScriptsStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scripts scripts = (Scripts) o;
        return Objects.equals(id, scripts.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}










