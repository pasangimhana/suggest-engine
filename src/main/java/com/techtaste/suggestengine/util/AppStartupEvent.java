package com.techtaste.suggestengine.util;

import com.techtaste.suggestengine.data.Suggestion;
import com.techtaste.suggestengine.service.SuggestionService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    private final SuggestionService suggestionService;

    public AppStartupEvent(SuggestionService suggestionService) {
        this.suggestionService = suggestionService;
    }

        @Override
        public void onApplicationEvent(ApplicationReadyEvent event) {
            List<Suggestion> suggestions = this.suggestionService.getSuggestions();
            suggestions.forEach(System.out::println);
            System.out.println("Application started ...");
        }
}
