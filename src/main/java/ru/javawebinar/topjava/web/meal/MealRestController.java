package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.AuthorizedUser;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.to.MealWithExceed;
import ru.javawebinar.topjava.util.MealsUtil;
import ru.javawebinar.topjava.util.TimeUtil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


/**
 * GKislin
 * 06.03.2015.
 */
@Controller
public class MealRestController {

    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private MealService service;

    public void update(Meal meal, int id) {
        meal.setId(id);
        int userId = AuthorizedUser.id();
        LOG.info("update {} for User {}", meal, userId);
        service.update(userId, meal);
    }

    public Meal create(Meal meal) {
        meal.setId(null);
        int userId = AuthorizedUser.id();
        LOG.info("create {} for User {}", meal, userId);
        return service.save(userId, meal);
    }

    public void delete(int id) {
        int userId = AuthorizedUser.id();
        LOG.info("delete meal {} for User {}", id, userId);
        service.delete(userId, id);
    }

    public Meal get(int id) {
        int userId = AuthorizedUser.id();
        LOG.info("get meal {} for User {}", id, userId);
        return service.get(userId, id);
    }

    public List<MealWithExceed> getAll() {
        int userId = AuthorizedUser.id();
        LOG.info("getAll for User {}", userId);
        return MealsUtil.getWithExceeded(service.getAll(userId), AuthorizedUser.getCaloriesPerDay());
    }

    public List<MealWithExceed> getBetween(LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime) {
        int userId = AuthorizedUser.id();
        LOG.info("getBetween dates {} - {} for time {} - {} for User {}", startDate, endDate, startTime, endTime, userId);
        return MealsUtil.getFilteredWithExceeded(
                service.getBetweenDates(userId,
                    startDate != null ? startDate : TimeUtil.MIN_DATE, endDate != null ? endDate : TimeUtil.MAX_DATE),
                startTime != null ? startTime : LocalTime.MIN,
                endTime != null ? endTime : LocalTime.MAX,
                AuthorizedUser.getCaloriesPerDay()
        );
    }

}
