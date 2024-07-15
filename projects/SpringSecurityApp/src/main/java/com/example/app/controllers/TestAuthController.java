package com.example.app.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class TestAuthController {

    @GetMapping("/get")
    public String helloGet() {
        return "Hello World - GET";
    }

    @PostMapping("/post")
    public String helloPost() {
        return "Hello World - POST";
    }

    @PutMapping("put")
    public String helloPut() {
        return "Hello World - PUT";
    }

    @DeleteMapping("/Hello World - DELETE")
    public String helloDelete() {
        return "Hello World = DELETE";
    }

    @PatchMapping("/patch")
    public String helloPatch() {
        return "Hello World - PATCH";
    }
}
