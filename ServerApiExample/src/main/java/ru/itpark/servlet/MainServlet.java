package ru.itpark.servlet;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import ru.itpark.models.User;
import ru.itpark.services.UsersService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {

    private UsersService usersService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/main.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/main.jsp").forward(request, response);

        String userNameSignUp = request.getParameter("usernamesignup");
        String emailSignUp = request.getParameter("emailsignup");
        String passwordSignUp = request.getParameter("passwordsignup");
        String passwordSignUp_confirm = request.getParameter("passwordsignup_confirm");

        if (passwordSignUp.equals(passwordSignUp_confirm)) {
            User user = new User(userNameSignUp, emailSignUp, passwordSignUp);
            usersService.register(user);
        }

    }



}
