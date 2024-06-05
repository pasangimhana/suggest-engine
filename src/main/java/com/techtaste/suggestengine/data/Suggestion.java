package com.techtaste.suggestengine.data;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "SUGGESTION")
public class Suggestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "suggestion", nullable = false)
    private String suggestion;

    @Column(name = "created_at", updatable = false, insertable = false)
    private LocalDateTime createdAt;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Suggestion{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", suggestion='" + suggestion + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
