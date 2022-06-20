package edu.school21.cinema.servlets;

import edu.school21.cinema.config.AppConf;
import edu.school21.cinema.models.Avatar;
import edu.school21.cinema.models.User;
import edu.school21.cinema.services.AvatarService;
import edu.school21.cinema.services.UserService;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Optional;

@WebServlet("/images")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class MultipartServlet extends HttpServlet {

    private UserService userService;
    private String avatarPath;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
        User user = (User) req.getSession().getAttribute("user");

        String UPLOAD_DIRECTORY = avatarPath + "/" + user.getLogin();
        Path avatarPath = Paths.get(UPLOAD_DIRECTORY);
        Files.createDirectories(avatarPath);

        String fileName = null;
        String fileOriginalName = null;
        String size = "size";
        String mime = "mime";

        for (Part part : req.getParts()) {
            fileOriginalName = getFileName(part);
            fileName = timeStamp + "_" + fileOriginalName;
            part.write(UPLOAD_DIRECTORY + File.separator + fileName);
        }
        user.setAvatar(new Avatar(user.getUserId(), fileName, fileOriginalName, size, mime));
        userService.updateAvatar(user);
//        user.setAvatar(uploadPath + File.separator + fileName);
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/profile.jsp").forward(req, resp);
    }

    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename"))
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
        }
        return "def_file_name";
//        return Constants.DEFAULT_FILENAME;
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        ApplicationContext applicationContext = (ApplicationContext) config.getServletContext().getAttribute("springContext");
        userService = applicationContext.getBean(UserService.class);
        avatarPath = applicationContext.getBean(AppConf.class).getAvatarPath();
        super.init(config);
    }
}
