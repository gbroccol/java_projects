package edu.school21.cinema.servlets;

import edu.school21.cinema.config.AppConf;
import edu.school21.cinema.models.User;
import edu.school21.cinema.models.UserAuthentication;
import edu.school21.cinema.services.AvatarService;
import edu.school21.cinema.services.UserAuthenticationService;
import edu.school21.cinema.services.UserService;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/error")
public class ErrorServlet extends HttpServlet {

//    private UserService userService;
//    private AvatarService avatarService;
//    private String avatarPath;
//    private UserAuthenticationService userAuthenticationService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
    }


    @Override
    public void init(ServletConfig config) throws ServletException {
//        ApplicationContext applicationContext = (ApplicationContext) config.getServletContext().getAttribute("springContext");
//        userService = applicationContext.getBean(UserService.class);
//        avatarService = applicationContext.getBean(AvatarService.class);
//        avatarPath = applicationContext.getBean(AppConf.class).getAvatarPath();
//        userAuthenticationService = applicationContext.getBean(UserAuthenticationService.class);
        super.init(config);
    }
}
