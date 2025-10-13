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
public class DashboardController {

    @Autowired
    private JournalService journalService;

    // 🏠 Main Dashboard (with optional date search)
    @GetMapping("/dashboard")
    public String dashboard(
            @RequestParam(name = "date", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            Model model) {

        // ✅ Always load main dashboard stats
        var allEntries = journalService.getAllEntries(null, null, null);
        model.addAttribute("totalEntries", allEntries.size());

        JournalEntry recent = journalService.getMostRecentEntry();
        if (recent != null) {
            model.addAttribute("recentEntry", recent.getTitle());
            model.addAttribute("recentDate", recent.getDate());
        } else {
            model.addAttribute("recentEntry", "No entries yet");
            model.addAttribute("recentDate", "-");
        }

        // ✅ If user searched by date
        if (date != null) {
            List<JournalEntry> entriesByDate = journalService.findEntriesByDate(date);
            model.addAttribute("entries", entriesByDate);
            model.addAttribute("searchedDate", date);
        }

        return "dashboard";
    }
}