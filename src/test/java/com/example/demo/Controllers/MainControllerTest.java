package com.example.demo.Controllers;

import com.example.demo.Services.MainService;
import org.junit.Before;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.runner.RunWith;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
@SpringBootTest
@AutoConfigureMockMvc
class MainControllerTest {

    @Autowired
    private MockMvc mvc;

    @Mock
    private MainService mainService;

    @InjectMocks
    private MainController mainController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        this.mvc = MockMvcBuilders.standaloneSetup(mainController).build();
    }

//    @Disabled("Просто так")
    @Test
    void getMainJSON() throws Exception {
        var errorNumber = 404;
        var expectedInfo = "404 not found ):";
        mvc.perform(MockMvcRequestBuilders.get("/")
                .param("errorNumber", String.valueOf(errorNumber)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.info").value(expectedInfo))
        .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}