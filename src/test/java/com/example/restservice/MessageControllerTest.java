package com.example.restservice;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.restservice.controller.MessageController;
import com.example.restservice.domain.Message;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(MessageController.class)
public class MessageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp()
    {
    }

    @Test
    public void testGetAll() throws Exception {
        this.mockMvc.perform(get("/message"))
                .andExpect(status().isOk())
                .andExpectAll(jsonPath("$", hasSize(0)))
                .andExpect(content().string("[]"));
    }

    @Test
    public void testCreateMessage() throws Exception {
        Message testMessage = new Message(1, "Test Data");

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(testMessage);

        this.mockMvc.perform(post("/message")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isOk());
        this.mockMvc.perform(get("/message"))
                .andDo(print())
                .andExpectAll(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].content", is("Test Data")))
                .andExpect(jsonPath("$[0].id", is(1)));
    }

    @Test
    public void testGetMessageById() throws Exception {
        Message testMessage = new Message(1, "Another Test Message");
        Message testMessage2 = new Message(2, "And Another Message");
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(testMessage);
        String requestJson2 = ow.writeValueAsString(testMessage2);

        this.mockMvc.perform(post("/message")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson));
        this.mockMvc.perform(post("/message")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson2));

         this.mockMvc.perform(get("/message/2"))
                .andExpect(jsonPath("$.content", is("And Another Message")))
                .andExpect(jsonPath("$.id", is(2)));

    }
}
