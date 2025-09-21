package com.aeta.aeta.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class RootController {
     //@return ResponseEntity<String>
    @GetMapping("/")
    public ResponseEntity<String> root() {
        return ResponseEntity.ok("Backend is running!");
    }
}
