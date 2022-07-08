package com.sportmaster.Todo.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDateTime;

@Document(indexName = "task")
public class Task {
    @Id
    @Field(type = FieldType.Keyword)
    private String id;

    @Field(type = FieldType.Text)
    private String content;

    @Field(type = FieldType.Date)
    private LocalDateTime dateTime;

    @Field(type = FieldType.Boolean)
    private Boolean isCompleted;

    public void setId(String id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }
}
