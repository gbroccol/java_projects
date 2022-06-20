package edu.school21.cinema.servlets;

import edu.school21.cinema.config.AppConf;
import edu.school21.cinema.models.User;
import edu.school21.cinema.services.AvatarService;
import edu.school21.cinema.services.UserService;
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
import java.util.Optional;

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute("user");








        String avatarFileName = req.getPathInfo() + "/gbroccol";

        Optional<Path> avatarPath = avatarService.resolveAvatarPath(avatarFileName.substring(1), user);
        if (avatarPath.isPresent()) {
            try (ServletOutputStream out = resp.getOutputStream()) {
                Files.copy(avatarPath.get(), out);
            }
        } else {
            resp.setStatus(400);
        }





        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute("user");
        String avatarFileName = req.getPathInfo(); //                   /photo_name
//
////        public static void main(String[] args) {
            File file = new File("/Users/gbroccol/Desktop/photo_here/gbroccol/2022-06-20 21:23:31_02.jpg");
//
//
//
//
////        {
//            response.setContentType("image/jpg");
//            ServletOutputStream out;
//            out = response.getOutputStream();
//            FileInputStream fin = new FileInputStream("c:\\test\\java.jpg");
//
//            BufferedInputStream bin = new BufferedInputStream(fin);
//            BufferedOutputStream bout = new BufferedOutputStream(out);
//            int ch =0; ;
//            while((ch=bin.read())!=-1)
//            {
//                bout.write(ch);
//            }
//
//            bin.close();
//            fin.close();
//            bout.close();
//            out.close();
////        }





        if (file.exists()) {
            request.getSession().setAttribute("error_code", "OK");                     // ?
        } else {
            request.getSession().setAttribute("error_code", ":(");                     // ?
        }


//        Optional<Path> avatarPath = avatarService.resolveAvatarPath(avatarFileName.substring(1), user);
//        if (avatarPath.isPresent()) {
//            try (ServletOutputStream out = resp.getOutputStream()) {
//                Files.copy(avatarPath.get(), out);
//                return;
//            }
//         }
//        else {
//            request.getSession().setAttribute("error_code", "400");                     // ?
//            request.getSession().setAttribute("error_msg", "Forbidden. No access");     // ?

//        request.getSession().setAttribute("error_code", avatarFileName + " - avatarFileName");                     // ?
        request.getSession().setAttribute("error_msg", avatarService.getAppAvatarsPath() + "/" + user.getLogin() + " - path");     // ?

        request.getRequestDispatcher("/error.jsp").forward(req, resp);                 // ?
            resp.setStatus(400);                                                              // ?
//        }
    }
}


//
//    public static void main(String[] args) {
//        File file = new File("/Users/pankaj/source.txt");
//        File notExist = new File("xyz.txt");
//
//        try {
//            System.out.println(file.getCanonicalPath() + " exists? "+file.exists());
//            System.out.println(notExist.getCanonicalPath() + " exists? "+notExist.exists());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//        if (user.getAvatar() == null || user.getAvatar().getFileName() == null)
//                return null;
//                Path avatarPath = appAvatarsPath.resolve(user.getAvatar().getFileName());
//                avatarPath = avatarPath.resolve(fileName);
//                return Files.exists(avatarPath) ? Optional.of(avatarPath) : Optional.empty();