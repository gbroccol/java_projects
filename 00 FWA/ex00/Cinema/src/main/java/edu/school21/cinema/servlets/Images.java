package edu.school21.cinema.servlets;

import edu.school21.cinema.models.User;
import edu.school21.cinema.services.AvatarService;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

@WebServlet("/images/*")
public class Images extends HttpServlet {

    private AvatarService avatarService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ApplicationContext applicationContext = (ApplicationContext) config.getServletContext().getAttribute("springContext");
        avatarService = applicationContext.getBean(AvatarService.class);
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute("user");
        Path p = avatarService.getAppAvatarsPath().resolve(user.getLogin());
        Path path = p.resolve(req.getPathInfo().substring(1));
        try (ServletOutputStream out = resp.getOutputStream()) {
            Files.copy(path, out);
        }
    }
}
