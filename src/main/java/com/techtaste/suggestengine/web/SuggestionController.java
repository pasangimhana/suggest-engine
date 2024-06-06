package com.techtaste.suggestengine.web;

import com.techtaste.suggestengine.data.Suggestion;
import com.techtaste.suggestengine.data.SuggestionDto;
import com.techtaste.suggestengine.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class SuggestionController {

    @Autowired
    private SuggestionService suggestionService;

    @GetMapping("/")
    public String showHomePage(Model model) {
        List<String> technologies = Arrays.asList(
                "Go + gRPC",
                "Scala + Akka",
                "Rust + Tokio",
                "Authentication Protocols - (OAuth, SAML, SSO, OAuth 2.0)",
                "Ansible + Jenkins",
                "Terraform + AWS",
                "Kubernetes + Helm"
        );
        model.addAttribute("technologies", technologies);
        model.addAttribute("suggestionDto", new SuggestionDto());
        return "index";
    }

    @PostMapping("/add-suggestion")
    public String submitSuggestion(@ModelAttribute SuggestionDto suggestionDto) {
        // Convert selected technologies to comma-separated string
        String technologies = String.join(", ", suggestionDto.getSelectedTechnologies());

        // Create Suggestion entity and populate fields
        Suggestion suggestion = new Suggestion();
        suggestion.setName(suggestionDto.getName());
        suggestion.setSuggestion(technologies + (suggestionDto.getSuggestion().isEmpty() ? "" : ", " + suggestionDto.getSuggestion()));

        // Save suggestion
        suggestionService.saveSuggestion(suggestion);

        // Redirect to success page
        return "redirect:/suggestion-success";
    }

    @GetMapping("/suggestion-success")
    public String showSuggestionSuccessPage() {
        return "suggestion-success";
    }

    @GetMapping("/suggestions")
    public String showSuggestions(Model model) {
        List<Suggestion> suggestions = suggestionService.getSuggestions();
        model.addAttribute("suggestions", suggestions);
        return "suggestions";
    }
}
