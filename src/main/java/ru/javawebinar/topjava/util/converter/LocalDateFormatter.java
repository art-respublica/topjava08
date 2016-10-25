package ru.javawebinar.topjava.util.converter;

import org.springframework.format.Formatter;
import ru.javawebinar.topjava.util.TimeUtil;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Created by Respublica on 25.10.2016.
 */
public class LocalDateFormatter implements Formatter<LocalDate> {

    @Override
    public LocalDate parse(String text, Locale locale) throws ParseException {
        return TimeUtil.parseLocalDate(text);
    }

    @Override
    public String print(LocalDate lt, Locale locale) {
        return lt.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
