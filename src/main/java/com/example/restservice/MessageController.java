package com.example.restservice;

import java.util.ArrayList;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {
    private final Counter counter = new Counter();
    private final ArrayList<Message> data = new ArrayList<>();

    // Create Route
    @PostMapping(path = "greeting", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createMessage(@RequestBody Message requestBody) {
        counter.incrementCount();
        Message newMessage = new Message(counter.getCount(), requestBody.getContent());
        data.add(newMessage);
    }

    // Read (all) Route
    @GetMapping("/greeting")
    public ArrayList<Message> getAllData() {
        return data;
    }

    // TODO: Read (by ID) Route
    @GetMapping("/greeting/{id}")
    public String showId(@PathVariable String id) {
        return String.format("ID is %s", id);
    }
}
