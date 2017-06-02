package ru.itpark.servlet;

import ru.itpark.models.User;
import ru.itpark.services.UsersService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UsersServlet extends HttpServlet {

    private UsersService usersService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String view = request.getParameter("view");
        if (view != null && view.equals("list")) {
            List<User> userList = usersService.getListOfUsers();
            request.setAttribute("users", userList);
            request.getRequestDispatcher("/jsp/users.jsp").forward(request, response);
        } else {
            String name = request.getParameter("name");
            String mail = request.getParameter("mail");
            String password = request.getParameter("password");
            User user = new User(name, mail, password);
            usersService.register(user);
        }
    }
}
