package org.study.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class CharFrequencyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCalculateFrequency() throws Exception {
        mockMvc.perform(post("/api/frequency")
                        .contentType(MediaType.TEXT_PLAIN)
                        .content("aaaaabcccc"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.a").value(5))
                .andExpect(jsonPath("$.c").value(4))
                .andExpect(jsonPath("$.b").value(1));
    }

    @Test
    public void testCalculateFrequencyNullInput() throws Exception {
        mockMvc.perform(post("/api/frequency")
                        .contentType(MediaType.TEXT_PLAIN)
                        .content(""))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testCalculateFrequencyTooLongInput() throws Exception {
        String longInput = new String(new char[11]).replace("\0", "a");

        mockMvc.perform(post("/api/frequency")
                        .contentType(MediaType.TEXT_PLAIN)
                        .content(longInput))
                .andExpect(status().isBadRequest());
    }
}