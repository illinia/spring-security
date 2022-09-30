package com.springsecurity.study;

import com.springsecurity.study.config.WithCustomUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MainTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void helloUnauthenticated() throws Exception {
        mvc.perform(get("/hello"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser
    public void helloAuthenticated() throws Exception {
        mvc.perform(get("/hello"))
                .andExpect(content().string("Hello!"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "mary")
    public void helloAuthenticatedName() throws Exception {
        mvc.perform(get("/helloName"))
                .andExpect(content().string("Hello, mary!"))
                .andExpect(status().isOk());
    }

    @Test
    public void helloAuthenticatedWithUser() throws Exception {
        mvc.perform(
                        get("/helloName").with(user("mary"))
                ).andExpect(content().string("Hello, mary!"))
                .andExpect(status().isOk());
    }

    @Test
    @WithUserDetails("john")
    public void helloAuthenticatedWithJohn() throws Exception {
        mvc.perform(get("/hello"))
                .andExpect(status().isOk());
    }

    @Test
    @WithCustomUser(username = "mary")
    public void helloAuthenticatedWithCustomUser() throws Exception {
        mvc.perform(get("/hello"))
                .andExpect(status().isOk());
    }
}
