package com.example.feedofcards;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CardsControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void dailyCardHasResponse() throws Exception {
        mvc.perform(get("/dailyCard").param("userId", "1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void dailyCardConditional() throws Exception {
        while (true) {
            MockHttpServletResponse response = mvc.perform(get("/dailyCardConditional").param("userId", "1"))
                    .andReturn().getResponse();
            if (response.getStatus() == HttpStatus.OK.value()) {
                assertTrue(response.getContentAsString().length() > 1);
                break;
            }
            if (response.getStatus() == HttpStatus.NO_CONTENT.value()) {
                continue;
            }
            fail("Exception response received.");
        }
    }

    @Test
    public void statusCardHasResponse() throws Exception {
        mvc.perform(get("/statusCard").param("userId", "1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void statusCardConditional() throws Exception {
        while (true) {
            MockHttpServletResponse response = mvc.perform(get("/statusCardConditional").param("userId", "1"))
                    .andReturn().getResponse();
            if (response.getStatus() == HttpStatus.OK.value()) {
                assertTrue(response.getContentAsString().length() > 1);
                break;
            }
            if (response.getStatus() == HttpStatus.NO_CONTENT.value()) {
                continue;
            }
            fail("Exception response received.");
        }
    }

}