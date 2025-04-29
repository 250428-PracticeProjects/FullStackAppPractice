package com.diary.personal_diary_app.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "diary_entries")
public class DiaryEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private LocalDate date;

    // Constructors
    public DiaryEntry() {}

    public DiaryEntry(String title, String content, LocalDate date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
