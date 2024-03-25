package com.example.calculate;

import com.example.calculate.service.CalculateService;
import com.example.calculate.service.impl.CalculateServiceImpl;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Optional;

import static java.time.temporal.ChronoUnit.DAYS;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class CalculateApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void calculateTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/calculate")
                        .param("averageSalary", "10000")
                        .param("start", "2024-01-02")
                        .param("end", "2024-01-15"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(content().string(Matchers.notNullValue()));

    }

    @Test
    public void test1() throws Exception {
        CalculateServiceImpl calculateService = new CalculateServiceImpl();
        String calculate = calculateService.calculate(10000, 7);
        Assert.assertEquals("2389,08", calculate);

    }




}
