package com.diary.personal_diary_app.repository;

import com.diary.personal_diary_app.model.DiaryEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryEntryRepository extends JpaRepository<DiaryEntry, Long> {
}

