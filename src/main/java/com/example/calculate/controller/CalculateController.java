package com.example.calculate.controller;

import com.example.calculate.service.CalculateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class CalculateController {
    private final CalculateService calculateService;
    @GetMapping("/calculate")
    public String calculate(@RequestParam double averageSalary,
                            @RequestParam(required = false) Integer days,
                            @RequestParam (required = false) LocalDate start,
                            @RequestParam (required = false)LocalDate end){
        if(start==null&& end==null){
            return  calculateService.calculate(averageSalary, days)+ " рублей";
        }
        if(days==null){
            return String.format("%.2f", calculateService.calculateWithDate(averageSalary,start,end))+ " рублей";
        }
   return "Заполните количество дней отпуска либо период отпуска!";
    }

}
