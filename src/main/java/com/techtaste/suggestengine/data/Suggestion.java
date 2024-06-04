package com.techtaste.suggestengine.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "SUGGESTION")
public class Suggestion {
    @Id
    @Column(name = "ID")
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SUGGESTION")
    private String suggestion;

    // this is auto generated by the db as current_timestamp as a timestamp type
    @Column(name = "CREATED_AT")
    private String createdAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
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