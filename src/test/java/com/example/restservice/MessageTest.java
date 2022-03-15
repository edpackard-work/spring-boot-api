package com.example.restservice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageTest {

    @Test
    public void CreatesAMessage() {
        Message message = new Message(1, "Test Message");
        assertEquals(1, message.getId());
        assertEquals("Test Message", message.getContent());
    }

    @Test
    public void UpdateAMessage() {
        Message message = new Message(999, "Update this message");
        message.setContent("Updated message");
        assertEquals(999, message.getId());
        assertEquals("Updated message", message.getContent());
    }
}
