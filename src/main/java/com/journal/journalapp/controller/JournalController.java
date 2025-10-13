package com.journal.journalapp.controller;

import com.journal.journalapp.model.JournalEntry;
import com.journal.journalapp.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class JournalController {

    @Autowired
    private JournalService journalService;

    @GetMapping("/entries")
    public String viewEntries(@RequestParam(required = false) String keyword,
                              @RequestParam(required = false) String mood,
                              @RequestParam(required = false) String date,
                              Model model) {
        LocalDate parsedDate = (date != null && !date.isEmpty()) ? LocalDate.parse(date) : null;
        model.addAttribute("entries", journalService.getAllEntries(keyword, mood, parsedDate));
        return "entries";
    }

    @GetMapping("/entries/add")
    public String addEntryForm(Model model) {
        model.addAttribute("entry", new JournalEntry());
        return "add-entry";
    }

    @PostMapping("/entries/add")
    public String saveEntry(@ModelAttribute JournalEntry entry) {
        journalService.save(entry);
        return "redirect:/entries";
    }

    @GetMapping("/entries/edit/{id}")
    public String editEntry(@PathVariable Long id, Model model) {
        model.addAttribute("entry", journalService.getEntryById(id));
        return "edit-entry";
    }

    @PostMapping("/entries/update/{id}")
    public String updateEntry(@PathVariable Long id, @ModelAttribute JournalEntry entry) {
        entry.setId(id);
        journalService.save(entry);
        return "redirect:/entries";
    }

    @GetMapping("/entries/delete/{id}")
    public String deleteEntry(@PathVariable Long id) {
        journalService.delete(id);
        return "redirect:/entries";
    }
}