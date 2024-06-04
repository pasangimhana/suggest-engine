package com.techtaste.suggestengine.service;

import com.techtaste.suggestengine.data.Suggestion;
import com.techtaste.suggestengine.data.SuggestionRepository;
import org.springframework.stereotype.Service;

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
}
