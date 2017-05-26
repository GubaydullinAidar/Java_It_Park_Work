package ru.itpark.servlet;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import ru.itpark.models.User;
import ru.itpark.service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("username");
        String password = request.getParameter("password");

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        ConfigurableEnvironment environment = context.getEnvironment();
        environment.setActiveProfiles("dev");
        context.load("ru.itpark\\context.xml");
        context.refresh();
        UsersService usersService = context.getBean(UsersService.class);

        User user = usersService.getUserByName(login);

        request.getSession().setAttribute("user", user);

        if (login.equals(user.getName()) && password.equals(user.getPassword())) {
            request.getRequestDispatcher("webapp/jsp/first.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Login or password incorrect");
            request.getRequestDispatcher("main.jsp").forward(request, response);
        }
    }
}
