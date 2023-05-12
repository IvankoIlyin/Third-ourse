package org.example;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.Servlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.example.controllers.LoginServlet;
import org.example.controllers.LogoutServlet;
import org.example.controllers.PatientListServlet;
import org.example.controllers.TestServlet;
import org.example.filters.CheckCookieFilter;
import org.example.model.PatientDao;
import org.example.model.User;
import org.example.model.UserDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.EnumSet;


//http://localhost:1488/login
//http://localhost:1488/test
public class App {
    private static final EnumSet<DispatcherType> ft = EnumSet.of(DispatcherType.REQUEST);
    public static void main(String[] args) throws Exception {



        Server server = new Server(1488);

        ServletContextHandler handler = new ServletContextHandler();


        Connection conn =  DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/OOPLab1",
                "postgres",
                "Slavaupa1488"
        );

        handler.addServlet(new ServletHolder(new LoginServlet(conn)),"/login");
        handler.addServlet(new ServletHolder(new TestServlet(conn)),"/test");
        handler.addServlet(new ServletHolder(new LogoutServlet()),"/logout");
        handler.addFilter(new FilterHolder(new CheckCookieFilter()), "/patients", ft);
        handler.addServlet(new ServletHolder(new PatientListServlet(conn, new PatientDao(),new UserDao())), "/patients");
        server.setHandler(handler);
        server.start();
    }



}