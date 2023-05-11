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
import org.example.model.PatientDao;
import org.example.model.User;
import org.example.model.UserDao;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Optional;

@RequiredArgsConstructor
public class TestServlet extends HttpServlet {
    private final Connection conn;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String curr_login = req.getParameter("login").toString();
//        String curr_password = req.getParameter("password").toString();
//        PatientDao patientDao = new PatientDao();
//        Patient patient = new Patient("Billy","kill","Hero","LSD2","lalala","no");
//        Optional<Patient> optionalPatient = patientDao.get("Leo");
//        patient = optionalPatient.get();
//        System.out.println(patient.getDiagnosis());

    }
}
