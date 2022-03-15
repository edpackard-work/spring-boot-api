package com.example.restservice;

import java.util.ArrayList;
import java.util.Optional;

import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {
    private final Counter counter = new Counter();
    private final ArrayList<Message> data = new ArrayList<>();

    // Create Route
    @PostMapping("message")
    public void createMessage(@RequestBody @NotNull Message requestBody) {
        counter.incrementCount();
        Message newMessage = new Message(counter.getCount(), requestBody.getContent());
        data.add(newMessage);
    }

    // Read (all) Route
    @GetMapping("/message")
    public ArrayList<Message> getAllData() {
        return data;
    }

    // Read (by ID) Route
    @GetMapping("/message/{id}")
    public Optional<Message> showId(@PathVariable long id) {
        return data.stream().filter(message -> message.getId() == id).findFirst();
    }

    // Update (by ID) Route
    @PutMapping("/message/{id}")
    public void updateMessage (@RequestBody Message requestBody, @PathVariable long id) {
        deleteById(id);
        Message newMessage = new Message(id, requestBody.getContent());
        data.add(newMessage);
    }

    // Delete (by ID) Route
    @DeleteMapping("/message/{id}")
    public void deleteMessage (@PathVariable long id) {
        deleteById(id);
    }

    private void deleteById( long id) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId() == id) {
                data.remove(i);
                break;
            }
        }
    }
}
