package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;

/**
 * GKislin
 * 15.06.2015.
 */
public interface MealService {

    Meal update(int userId, Meal meal) throws NotFoundException;

    Meal save(int userId, Meal meal);

    void delete(int userId, int id) throws NotFoundException;

    Meal get(int userId, int id) throws NotFoundException;

    Collection<Meal> getAll(int userId);

    Collection<Meal> getBetweenDateTimes(int userId, LocalDateTime startDateTime, LocalDateTime endDateTime);

    default Collection<Meal> getBetweenDates(int userId, LocalDate startDate, LocalDate endDate) {
        return getBetweenDateTimes(userId, LocalDateTime.of(startDate, LocalTime.MIN), LocalDateTime.of(endDate, LocalTime.MAX));
    }
}
