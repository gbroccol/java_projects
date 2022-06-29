package edu.school21.cinema.servlets;

import edu.school21.cinema.config.AppConf;
import edu.school21.cinema.models.User;
import edu.school21.cinema.models.UserAuthentication;
import edu.school21.cinema.repositories.NotSavedSubEntityException;
import edu.school21.cinema.services.AvatarService;
import edu.school21.cinema.services.UserAuthenticationService;
import edu.school21.cinema.services.UserService;
import org.springframework.context.ApplicationContext;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {

    private UserService userService;
    private AvatarService avatarService;
    private String avatarPath;
    private UserAuthenticationService userAuthenticationService;

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

        try {
            userService.save(user);
        } catch (NotSavedSubEntityException e) {
            HttpSession session = request.getSession();
            session.setAttribute("error_msg", "Login exists.");
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/signUp.jsp").forward(request, response);
            return;
        }

        request.getSession().setAttribute("user", user);
        request.getSession().setAttribute("avatarPath", avatarPath);
        request.getSession().setAttribute("avatarService", avatarService);

        String ip = request.getRemoteHost();
        if (ip.equals("0:0:0:0:0:0:0:1")) {
            userAuthenticationService.save(user, "127.0.0.1");
        } else {
            userAuthenticationService.save(user, ip);
        }
        List<UserAuthentication> authList = userAuthenticationService.findAllByUserId(user.getUserId().toString());
        request.getSession().setAttribute("auth_list", authList);
        response.sendRedirect(request.getContextPath() + "/profile");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        ApplicationContext applicationContext = (ApplicationContext) config.getServletContext().getAttribute("springContext");
        userService = applicationContext.getBean(UserService.class);
        avatarService = applicationContext.getBean(AvatarService.class);
        avatarPath = applicationContext.getBean(AppConf.class).getAvatarPath();
        userAuthenticationService = applicationContext.getBean(UserAuthenticationService.class);
        super.init(config);
    }
}
