package com.example.restservice;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    private final Counter counter = new Counter();
    private final ArrayList<Message> data = new ArrayList<>();

    @GetMapping("/greeting")
    public Message greeting(@RequestParam(value = "message", defaultValue = "Hello World!") String message) {
        counter.incrementCount();
        Message newMessage =  new Message(counter.getCount(), message);
        data.add(newMessage);
        return newMessage;
    }

    @GetMapping("/greeting/all")
    public ArrayList<Message> getAllData() {
        return data;
    }

    @GetMapping("/greeting/{id}")
    public String showId(@PathVariable String id) {
        return String.format("ID is %s", id);
    }
}
