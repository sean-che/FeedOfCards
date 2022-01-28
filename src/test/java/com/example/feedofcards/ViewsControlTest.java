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
class ViewsControlTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void dailyCardUserCanSeeOnlyOnce() throws Exception {
        mvc.perform(get("/dailyCard").param("userId", "21"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        mvc.perform(get("/dailyCard").param("userId", "21"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void dailyCardDifferentUsersCanSee() throws Exception {
        mvc.perform(get("/dailyCard").param("userId", "22"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        mvc.perform(get("/dailyCard").param("userId", "23"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void dailyCardEmptyUserCanSeeAlways() throws Exception {
        mvc.perform(get("/dailyCard").param("userId", ""))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        mvc.perform(get("/dailyCard").param("userId", ""))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void statusCardUserCanSeeOnlyOnce() throws Exception {
        mvc.perform(get("/statusCard").param("userId", "31"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        mvc.perform(get("/statusCard").param("userId", "31"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void statusCardDifferentUsersCanSee() throws Exception {
        mvc.perform(get("/statusCard").param("userId", "32"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        mvc.perform(get("/statusCard").param("userId", "33"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void statusCardEmptyUserCanSeeAlways() throws Exception {
        mvc.perform(get("/statusCard").param("userId", ""))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        mvc.perform(get("/statusCard").param("userId", ""))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

}