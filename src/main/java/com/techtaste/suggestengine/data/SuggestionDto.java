package com.techtaste.suggestengine.data;
import java.util.List;

public class SuggestionDto {
    private String name;
    private List<String> selectedTechnologies;
    private String suggestion;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSelectedTechnologies() {
        return selectedTechnologies;
    }

    public void setSelectedTechnologies(List<String> selectedTechnologies) {
        this.selectedTechnologies = selectedTechnologies;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }
}