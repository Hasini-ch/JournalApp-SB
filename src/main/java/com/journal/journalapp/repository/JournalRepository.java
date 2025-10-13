package com.journal.journalapp.repository;

import com.journal.journalapp.model.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JournalRepository extends JpaRepository<JournalEntry, Long> {

    // ✅ Mood count that ignores case and spaces
	@Query("SELECT COUNT(j) FROM JournalEntry j WHERE LOWER(TRIM(FUNCTION('REPLACE', j.mood, '😊 ', ''))) = LOWER(:mood) OR LOWER(TRIM(FUNCTION('REPLACE', j.mood, '😐 ', ''))) = LOWER(:mood) OR LOWER(TRIM(FUNCTION('REPLACE', j.mood, '😢 ', ''))) = LOWER(:mood)")
	long countMood(@Param("mood") String mood);
}