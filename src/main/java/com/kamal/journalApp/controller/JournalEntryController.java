package com.kamal.journalApp.controller;

import com.kamal.journalApp.entity.JournalEntry;
import com.kamal.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping("/get-all")
    public List<JournalEntry> getAllJournals(){
        return journalEntryService.getAll();
    }

    @GetMapping("/get-one/{id}")
    public JournalEntry getJournalById(@PathVariable ObjectId id) {
        return journalEntryService.getJournalById(id).orElse(null); // because id may or may not be exists
    }

    @PostMapping("/add")
    public JournalEntry createJournal(@RequestBody JournalEntry newEntry) {
        newEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(newEntry);
        return newEntry;
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteJournal(@PathVariable ObjectId id) {
        journalEntryService.deleteById(id);
        return true;
    }

    @PutMapping("/update/{id}")
    public JournalEntry updateJournal(@PathVariable ObjectId id, @RequestBody JournalEntry updated) {
        JournalEntry old = journalEntryService.getJournalById(id).orElse(null);
        if(old != null){
            old.setTitle(updated.getTitle() != null && !updated.getTitle().equals("") ? updated.getTitle() : old.getTitle());
            old.setContent(updated.getContent() != null && !updated.getContent().equals("") ? updated.getContent() : old.getContent());
            journalEntryService.saveEntry(old);
            return old;
        }
        else return null;
    }
}
