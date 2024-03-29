package com.hotel.demo.formatter;

import com.hotel.demo.model.Home;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocalDateFormatter implements Formatter<LocalDate> {

    @Override
    public LocalDate parse(String text, Locale locale) throws ParseException {
        if (text != null) {
            return LocalDate.parse(text, DateTimeFormatter.ISO_LOCAL_DATE);
        } else {
            return LocalDate.now();
        }
    }

    @Override
    public String print (LocalDate localDate, Locale locale) {
        if (localDate == null) {
            return "";
        }
        return localDate.toString();
    }
}
