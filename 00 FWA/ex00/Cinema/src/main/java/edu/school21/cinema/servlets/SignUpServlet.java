package edu.school21.cinema.servlets;

import edu.school21.cinema.config.AppConf;
import edu.school21.cinema.models.User;
import edu.school21.cinema.services.AvatarService;
import edu.school21.cinema.services.UserService;
import org.springframework.context.ApplicationContext;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {

    private UserService userService;
    private AvatarService avatarService;
    private String avatarPath;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/signUp.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = new User(request.getParameter("login"),
                                request.getParameter("password"),
                                request.getParameter("first_name"),
                                request.getParameter("last_name"),
                                request.getParameter("phone_number"),
                                request.getParameter("email"));

        userService.save(user);
        request.getSession().setAttribute("user", user);
        request.getSession().setAttribute("avatarPath", avatarPath);
        request.getSession().setAttribute("avatarService", avatarService);
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/profile.jsp").forward(request, response); //
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        ApplicationContext applicationContext = (ApplicationContext) config.getServletContext().getAttribute("springContext");
        userService = applicationContext.getBean(UserService.class);
        avatarService = applicationContext.getBean(AvatarService.class);
        avatarPath = applicationContext.getBean(AppConf.class).getAvatarPath();
        super.init(config);
    }
}
