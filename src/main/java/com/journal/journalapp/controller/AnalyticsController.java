package com.journal.journalapp.controller;

import com.journal.journalapp.model.JournalEntry;
import com.journal.journalapp.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class AnalyticsController {

    @Autowired
    private JournalService journalService;

    @GetMapping("/analytics")
    public String analytics(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String mood,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate,
            Model model) {

        // ✅ 1. Fetch filtered entries (for table)
        List<JournalEntry> filteredEntries = journalService.filterEntries(keyword, mood, fromDate, toDate);

        // ✅ 2. Fetch overall mood counts directly from DB
        long happyCount = journalService.countByMood("Happy");
        long sadCount = journalService.countByMood("Sad");
        long neutralCount = journalService.countByMood("Neutral");

        // ✅ 3. Add to model
        model.addAttribute("entries", filteredEntries);
        model.addAttribute("keyword", keyword);
        model.addAttribute("mood", mood);
        model.addAttribute("fromDate", fromDate);
        model.addAttribute("toDate", toDate);

        model.addAttribute("happyCount", happyCount);
        model.addAttribute("sadCount", sadCount);
        model.addAttribute("neutralCount", neutralCount);

        model.addAttribute("totalEntries", filteredEntries.size());

        return "analytics"; // thymeleaf file name
    }
}