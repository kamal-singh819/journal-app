package com.kamal.journalApp.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

//It is a POJO Class: "Plain Old java Object" class : => now change it to mongodb document using @Document

@Document(collection = "journals") // it tells spring to convert this POJO class into a mongodb Document
public class JournalEntry {
    @Id //make id as Primary Key or Unique Key
    private ObjectId id;
    private String title;
    private String content;
    private LocalDateTime date;

    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }

    public ObjectId getId(){
        return id;
    }
    public void setId(ObjectId id){
        this.id = id;
    }

    public String getTitle(){ return title; }
    public void setTitle(String title){
        this.title = title;
    }

    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content = content;
    }
}
