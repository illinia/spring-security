package com.springsecurity.study;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class MainTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void loggingInWithWrongUser() throws Exception {
        mvc.perform(formLogin()
                .user("joey").password("12345"))
                .andExpect(header().exists("failed"))
                .andExpect(unauthenticated());
    }

    @Test
    public void loggingInWithWrongAuthority() throws Exception {
        mvc.perform(formLogin()
                        .user("mary").password("12345")
                )
                .andExpect(redirectedUrl("/error"))
                .andExpect(status().isFound())
                .andExpect(authenticated());
    }

    @Test
    public void loggingInWithCorrectAuthority() throws Exception {
        mvc.perform(formLogin()
                        .user("bill").password("12345")
                ).andExpect(redirectedUrl("/home"))
                .andExpect(status().isFound())
                .andExpect(authenticated());
    }
}
