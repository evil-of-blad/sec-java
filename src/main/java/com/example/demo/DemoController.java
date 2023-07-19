package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoController {

    private List<String> messages = new ArrayList<>();

    @GetMapping("/hello")
    public String getHello() {
        return "Hello, World!";
    }

    @PostMapping("/message")
    public String addMessage(@RequestBody String message) {
        messages.add(message);
        return "Message added successfully.";
    }

    @GetMapping("/messages")
    public List<String> getMessages() {
        return messages;
    }

    @GetMapping("/message/{index}")
    public String getMessageByIndex(@PathVariable int index) {
        if (index < messages.size()) {
            return messages.get(index);
        } else {
            return "Message not found.";
        }
    }
}
