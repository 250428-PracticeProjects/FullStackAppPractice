
package com.diary.personal_diary_app.controller;

import com.diary.personal_diary_app.model.DiaryEntry;
import com.diary.personal_diary_app.service.DiaryEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/diary")
@CrossOrigin(origins = "http://localhost:3000") // Allow frontend access
public class DiaryEntryController {

    @Autowired
    private DiaryEntryService diaryEntryService;

    @PostMapping
    public DiaryEntry createEntry(@RequestBody DiaryEntry diaryEntry) {
        return diaryEntryService.createEntry(diaryEntry);
    }

    @GetMapping
    public List<DiaryEntry> getAllEntries() {
        return diaryEntryService.getAllEntries();
    }

    @GetMapping("/{id}")
    public Optional<DiaryEntry> getEntryById(@PathVariable Long id) {
        return diaryEntryService.getEntryById(id);
    }

    @PutMapping("/{id}")
    public DiaryEntry updateEntry(@PathVariable Long id, @RequestBody DiaryEntry diaryEntry) {
        return diaryEntryService.updateEntry(id, diaryEntry);
    }

    @DeleteMapping("/{id}")
    public void deleteEntry(@PathVariable Long id) {
        diaryEntryService.deleteEntry(id);
    }
}
