package edu.school21.cinema.servlets;

import edu.school21.cinema.models.User;
//import edu.school21.cinema.services.AvatarService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

//@WebServlet("/images/*")
//public class ImageServlet extends HttpServlet {
//
////    private AvatarService avatarService;
//
//    @Override
//    public void init(ServletConfig config) throws ServletException {
////        ApplicationContext applicationContext = (ApplicationContext) config.getServletContext().getAttribute("springContext");
////        avatarService = applicationContext.getBean(AvatarService.class);
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//
////        req.getSession().invalidate();
//
//
//
//
////        HttpSession session = req.getSession(false);
////        User user = (User) session.getAttribute("user");
//
//
////        String avatarFileName = req.getPathInfo();
//
////        Optional<Path> avatarPath = avatarService.resolveAvatarPath(avatarFileName.substring(1), user);
////        if (avatarPath.isPresent()) {
////            try (ServletOutputStream out = resp.getOutputStream()) {
////                Files.copy(avatarPath.get(), out);
////            }
////        } else {
//            resp.setStatus(400);
//            getServletContext().getRequestDispatcher("/WEB-INF/jsp/signIn.jsp").forward(req, resp);
////        }
//    }
//}
