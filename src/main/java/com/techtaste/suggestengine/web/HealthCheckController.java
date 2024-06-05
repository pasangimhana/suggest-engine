package com.techtaste.suggestengine.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping("/checkserver")
    public HttpStatus checkServer() {
        return HttpStatus.OK;
    }
}
