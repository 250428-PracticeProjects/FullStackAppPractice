package com.diary.personal_diary_app.service;

import com.diary.personal_diary_app.model.DiaryEntry;
import com.diary.personal_diary_app.repository.DiaryEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiaryEntryService {

    @Autowired
    private DiaryEntryRepository diaryEntryRepository;

    public DiaryEntry createEntry(DiaryEntry entry) {
        return diaryEntryRepository.save(entry);
    }

    public List<DiaryEntry> getAllEntries() {
        return diaryEntryRepository.findAll();
    }

    public Optional<DiaryEntry> getEntryById(Long id) {
        return diaryEntryRepository.findById(id);
    }

    public DiaryEntry updateEntry(Long id, DiaryEntry entryDetails) {
        DiaryEntry entry = diaryEntryRepository.findById(id).orElseThrow();
        entry.setTitle(entryDetails.getTitle());
        entry.setContent(entryDetails.getContent());
        entry.setDate(entryDetails.getDate());
        return diaryEntryRepository.save(entry);
    }

    public void deleteEntry(Long id) {
        diaryEntryRepository.deleteById(id);
    }
}

