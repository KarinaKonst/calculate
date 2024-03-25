package com.example.calculate.service.impl;

import com.example.calculate.service.CalculateService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;


@Service
public class CalculateServiceImpl implements CalculateService {
    List<Calendar> dateHolidays = new ArrayList<>();

    @Override
    public String calculate(double averageSalary, int days) {

        return String.format("%.2f", ((averageSalary * 12) / (29.3 * 12)) * days);
    }

    @Override
    public Double calculateWithDate(double averageSalary, LocalDate start, LocalDate end) {

        int holidays = 0;
        addHolidays();
        Calendar startDate = Calendar.getInstance();
        startDate.set(start.getYear(), start.getMonthValue() - 1, start.getDayOfMonth());

        Calendar endDate = Calendar.getInstance();
        endDate.set(end.getYear(), end.getMonthValue() - 1, end.getDayOfMonth());
        while (startDate.before(endDate)) {

            for (Calendar a : dateHolidays) {
                if (isHolidays(startDate, a)) {
                    holidays++;
                }

            }
            startDate.add(Calendar.DAY_OF_MONTH, 1);
        }
        long days = DAYS.between(start, end) + 1 - holidays;
        return ((averageSalary * 12) / (29.3 * 12)) * days;
    }

    private static boolean isHolidays(Calendar date, Calendar holidayDate) {
        return date.get(Calendar.DAY_OF_MONTH) == holidayDate.get(Calendar.DAY_OF_MONTH) && date.get(Calendar.MONTH) == holidayDate.get(Calendar.MONTH);


    }

    private void addHolidays() {
        Calendar newYear = Calendar.getInstance();
        newYear.set(Calendar.MONTH, Calendar.JANUARY);
        newYear.set(Calendar.DAY_OF_MONTH, 1);
        dateHolidays.add(newYear);

        Calendar christmas = Calendar.getInstance();
        christmas.set(Calendar.MONTH, Calendar.JANUARY);
        christmas.set(Calendar.DAY_OF_MONTH, 7);
        dateHolidays.add(christmas);

        Calendar defenderDay = Calendar.getInstance();
        defenderDay.set(Calendar.MONTH, Calendar.FEBRUARY);
        defenderDay.set(Calendar.DAY_OF_MONTH, 23);
        dateHolidays.add(defenderDay);

        Calendar womanDay = Calendar.getInstance();
        womanDay.set(Calendar.MONTH, Calendar.MARCH);
        womanDay.set(Calendar.DAY_OF_MONTH, 8);
        dateHolidays.add(womanDay);

        Calendar laborDay = Calendar.getInstance();
        laborDay.set(Calendar.MONTH, Calendar.MAY);
        laborDay.set(Calendar.DAY_OF_MONTH, 1);
        dateHolidays.add(laborDay);

        Calendar victoryDay = Calendar.getInstance();
        victoryDay.set(Calendar.MONTH, Calendar.MAY);
        victoryDay.set(Calendar.DAY_OF_MONTH, 9);
        dateHolidays.add(victoryDay);

        Calendar dayRussian = Calendar.getInstance();
        dayRussian.set(Calendar.MONTH, Calendar.JUNE);
        dayRussian.set(Calendar.DAY_OF_MONTH, 12);
        dateHolidays.add(dayRussian);

        Calendar nationalUnityDay = Calendar.getInstance();
        nationalUnityDay.set(Calendar.MONTH, Calendar.NOVEMBER);
        nationalUnityDay.set(Calendar.DAY_OF_MONTH, 4);
        dateHolidays.add(nationalUnityDay);

    }

}
