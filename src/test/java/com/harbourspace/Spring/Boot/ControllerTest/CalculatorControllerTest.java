package com.harbourspace.Spring.Boot.ControllerTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculatorControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void sumTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/calc/sum")
                        .param("a", String.valueOf(3))
                        .param("b", String.valueOf(4)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(String.valueOf(7)));
    }

    @Test
    void sumWithWrongValueTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/calc/multiply")
                        .param("a", String.valueOf(0.5))
                        .param("b", String.valueOf(2)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void multiplyTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/calc/multiply")
                        .param("a", String.valueOf(3))
                        .param("b", String.valueOf(4)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(String.valueOf(12)));
    }

    @Test
    void multiplyWithWrongValueTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/calc/multiply")
                        .param("a", String.valueOf(3))
                        .param("b", String.valueOf(4.5)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}
