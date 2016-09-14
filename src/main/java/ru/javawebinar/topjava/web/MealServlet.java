package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by Respublica on 14.09.2016.
 */
public class MealServlet extends HttpServlet {

    private static final Logger LOG = getLogger(MealServlet.class);

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LOG.debug("redirect to mealList");

        req.setAttribute("mealList", MealsUtil.getWithExceeded(MealsUtil.MEAL_LIST, MealsUtil.DEFAULT_CALORIES_PER_DAY));
        req.getRequestDispatcher("/mealList.jsp").forward(req, resp);
    }
}
