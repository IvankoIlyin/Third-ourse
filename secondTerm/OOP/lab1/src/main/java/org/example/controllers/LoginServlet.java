package org.example.controllers;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.example.model.Patient;
import org.example.model.User;
import org.example.model.UserDao;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Optional;
import java.util.logging.Logger;

@RequiredArgsConstructor
public class LoginServlet extends HttpServlet {
    private final Connection conn;
    private static final Logger log = Logger.getLogger(String.valueOf(LoginServlet.class));
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String curr_login = req.getParameter("login").toString();
        String curr_password = req.getParameter("password").toString();
        UserDao userDao = new UserDao();
        Optional<User> optionalUser = userDao.get(curr_login);
        if(optionalUser.isEmpty()){
            resp.sendRedirect("/login");
            log.info("User "+curr_login+" not exist");
        }
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            if(user.getPassword().equals(curr_password)){
                resp.sendRedirect("/patients");
                log.info("User "+curr_login+" redirect to /patients");
            }
            else {
                resp.sendRedirect("/login");
                log.info("User "+curr_login+" wrong password");
            }
        }
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Configuration conf = new Configuration(Configuration.VERSION_2_3_31);
        conf.setDefaultEncoding(String.valueOf(StandardCharsets.UTF_8));
        conf.setDirectoryForTemplateLoading(new File("static-content"));

        HashMap<String, Object> data = new HashMap<>();

        try (PrintWriter w = resp.getWriter()) {
            conf.getTemplate("login.ftl").process(data, w);
        } catch (TemplateException x) {
            throw new RuntimeException(x);
        }


    }
}
