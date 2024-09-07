package com.kamal.journalApp.controller;

import com.kamal.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
    private Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping("/get-all")
    public List<JournalEntry> getAllJournals(){
        return new ArrayList<>(journalEntries.values());
    }

    @GetMapping("/get-one/{id}")
    public JournalEntry getJournalById(@PathVariable Long id) {
        return journalEntries.get(id);
    }

    @PostMapping("/add")
    public boolean createJournal(@RequestBody JournalEntry newEntry) {
        journalEntries.put(newEntry.getId(), newEntry);
        return true;
    }

    @DeleteMapping("/delete/{id}")
    public JournalEntry deleteJournal(@PathVariable Long id) {
        return journalEntries.remove(id);
    }

    @PutMapping("/update/{id}")
    public JournalEntry updateJournal(@PathVariable Long id, @RequestBody JournalEntry updated) {
        return journalEntries.put(id, updated);
    }
}
