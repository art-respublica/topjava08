package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.util.Collection;

/**
 * GKislin
 * 06.03.2015.
 */
public interface MealRepository {

    Meal save(int userId, Meal Meal);

    boolean delete(int userId, int id);

    Meal get(int userId, int id);

    Collection<Meal> getAll(int userId);

    Collection<Meal> getBetween(int userId, LocalDateTime startDate, LocalDateTime endDate);
}
