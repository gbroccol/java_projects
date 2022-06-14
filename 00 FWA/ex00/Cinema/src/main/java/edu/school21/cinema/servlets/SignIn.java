package edu.school21.cinema.servlets;

import edu.school21.cinema.models.User;
import edu.school21.cinema.models.UserAuthentication;
import edu.school21.cinema.services.UserAuthenticationService;
import edu.school21.cinema.services.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/signIn")
public class SignIn extends HttpServlet {

    private UserService userService;
    private UserAuthenticationService userAuthenticationService;
    private BCryptPasswordEncoder encoder;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/signIn.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        Optional <User> optionalUser = userService.findByLogin(login);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (encoder.matches(password, user.getPassword())) {
                request.getSession().setAttribute("user", optionalUser.get());
                String ip = request.getRemoteHost();
                if (ip.equals("0:0:0:0:0:0:0:1")) {
                    userAuthenticationService.save(user, "127.0.0.1");
                } else {
                    userAuthenticationService.save(user, ip);
                }
                List<UserAuthentication> authList = userAuthenticationService.findAllByUserId(user.getUserId().toString());
                request.getSession().setAttribute("auth_list", authList);
                getServletContext().getRequestDispatcher("/WEB-INF/jsp/profile.jsp").forward(request, response);

            } else {
                request.getSession().setAttribute("error_msg", "Password is not correct");
                getServletContext().getRequestDispatcher("/WEB-INF/jsp/signIn.jsp").forward(request, response);
            }
        } else {
            request.getSession().setAttribute("error_msg", "Login is not correct");
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/signIn.jsp").forward(request, response);
        }
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        ApplicationContext applicationContext = (ApplicationContext) config.getServletContext().getAttribute("springContext");
        userService = applicationContext.getBean(UserService.class);
        userAuthenticationService = applicationContext.getBean(UserAuthenticationService.class);
        encoder = new BCryptPasswordEncoder();
        super.init(config);
    }
}
