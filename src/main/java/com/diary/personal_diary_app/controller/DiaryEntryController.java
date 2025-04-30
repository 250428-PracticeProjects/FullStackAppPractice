package com.diary.personal_diary_app.controller;

import com.diary.personal_diary_app.model.DiaryEntry;
import com.diary.personal_diary_app.service.DiaryEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/diary")
@CrossOrigin(origins = "http://localhost:3000") // Allow frontend access
public class DiaryEntryController {

    @Autowired
    private DiaryEntryService diaryEntryService;

    // List of rotating daily quotes
    private final List<String> quotes = List.of(
            "Start where you are. Use what you have. Do what you can.",
            "Every moment is a fresh beginning.",
            "Do something today that your future self will thank you for.",
            "Believe you can and you're halfway there.",
            "Progress, not perfection."
    );

    @PostMapping
    public ResponseEntity<DiaryEntry> createEntry(@RequestBody DiaryEntry diaryEntry) {
        DiaryEntry savedEntry = diaryEntryService.createEntry(diaryEntry);
        return ResponseEntity.ok(savedEntry);
    }

    @GetMapping
    public ResponseEntity<List<DiaryEntry>> getAllEntries() {
        return ResponseEntity.ok(diaryEntryService.getAllEntries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiaryEntry> getEntryById(@PathVariable Long id) {
        Optional<DiaryEntry> entry = diaryEntryService.getEntryById(id);
        return entry.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiaryEntry> updateEntry(@PathVariable Long id, @RequestBody DiaryEntry diaryEntry) {
        DiaryEntry updatedEntry = diaryEntryService.updateEntry(id, diaryEntry);
        return ResponseEntity.ok(updatedEntry);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntry(@PathVariable Long id) {
        Optional<DiaryEntry> entry = diaryEntryService.getEntryById(id);
        if (entry.isPresent()) {
            diaryEntryService.deleteEntry(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build();  // 404 Not Found
        }
    }

    @GetMapping("/quote")
    public ResponseEntity<String> getDailyQuote() {
        int dayOfYear = LocalDate.now().getDayOfYear();
        int index = dayOfYear % quotes.size();
        return ResponseEntity.ok(quotes.get(index));
    }
}
