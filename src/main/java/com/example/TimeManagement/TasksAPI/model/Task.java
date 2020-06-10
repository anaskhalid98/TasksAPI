package com.example.TimeManagement.TasksAPI.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

@Entity
@Table(name = "TASK")
public class Task {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    private String content;

    private Boolean completed;

    public Task(){
        super();
    }

    public Task(@JsonProperty("content") String content,@JsonProperty("completed") Boolean completed) {
        super();
        this.content = content;
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
