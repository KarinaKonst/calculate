package com.example.calculate.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface CalculateService {
    public String calculate(double averageSalary, int days);
    public Double calculateWithDate(double averageSalary, LocalDate start, LocalDate end);
}
