package com.techtaste.suggestengine.service;

import com.techtaste.suggestengine.data.Suggestion;
import com.techtaste.suggestengine.data.SuggestionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class SuggestionService {
    private final SuggestionRepository suggestionRepository;

    public SuggestionService(SuggestionRepository suggestionRepository) {
        this.suggestionRepository = suggestionRepository;
    }

    public List<Suggestion> getSuggestions() {
        return this.suggestionRepository.findAll();
    }

    public void saveSuggestion(Suggestion suggestion) {
        if (suggestion == null) {
            throw new RuntimeException("Suggestion cannot be null");
        }
        this.suggestionRepository.save(suggestion);
    }
}
