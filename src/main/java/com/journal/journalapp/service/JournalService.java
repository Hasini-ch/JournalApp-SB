package com.journal.journalapp.service;

import com.journal.journalapp.model.JournalEntry;
import com.journal.journalapp.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JournalService {

    @Autowired
    private JournalRepository journalRepository;

    public List<JournalEntry> getAllEntries(String keyword, String mood, LocalDate date) {
        List<JournalEntry> entries = journalRepository.findAll();
        return entries.stream()
                .filter(e -> (keyword == null || e.getTitle().toLowerCase().contains(keyword.toLowerCase())
                        || e.getContent().toLowerCase().contains(keyword.toLowerCase())))
                .filter(e -> (mood == null || mood.isEmpty() || e.getMood().equalsIgnoreCase(mood)))
                .filter(e -> (date == null || e.getDate().equals(date)))
                .collect(Collectors.toList());
    }

    public JournalEntry getEntryById(Long id) {
        return journalRepository.findById(id).orElse(null);
    }

    public void save(JournalEntry entry) {
        journalRepository.save(entry);
    }

    public void delete(Long id) {
        journalRepository.deleteById(id);
    }

    public long countByMood(String mood) {
        long count = journalRepository.countMood(mood);
        System.out.println("🎯 Checking mood: '" + mood + "'");
        System.out.println("✅ Count in DB: " + count);
        return count;
    }
    
    public JournalEntry getMostRecentEntry() {
        List<JournalEntry> all = journalRepository.findAll();
        return all.isEmpty() ? null : all.get(all.size() - 1);
    }

    public List<JournalEntry> findEntriesByDate(LocalDate date) {
        return journalRepository.findAll().stream()
                .filter(e -> e.getDate() != null && e.getDate().equals(date))
                .collect(Collectors.toList());
    }

    public List<JournalEntry> filterEntries(String keyword, String mood, LocalDate fromDate, LocalDate toDate) {
        return journalRepository.findAll().stream()
                .filter(e -> (keyword == null || e.getTitle().toLowerCase().contains(keyword.toLowerCase())
                        || e.getContent().toLowerCase().contains(keyword.toLowerCase())))
                .filter(e -> (mood == null || mood.isEmpty() || e.getMood().equalsIgnoreCase(mood)))
                .filter(e -> (fromDate == null || (e.getDate() != null && !e.getDate().isBefore(fromDate))))
                .filter(e -> (toDate == null || (e.getDate() != null && !e.getDate().isAfter(toDate))))
                .collect(Collectors.toList());
    }
}