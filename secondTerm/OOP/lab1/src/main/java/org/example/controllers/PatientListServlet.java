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

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

@RequiredArgsConstructor
public class PatientListServlet extends HttpServlet {
    private final Connection conn;
    ArrayList<Patient> patients;
    private final PatientDao patientDao;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (Patient i: this.patients){
            String curr_procedures=req.getParameter(i.getId()+"_procedures").toString();
            String curr_diagnosis=req.getParameter(i.getId()+"_diagnosis").toString();
            String curr_medicines=req.getParameter(i.getId()+"_medicines").toString();
            String curr_operations=req.getParameter(i.getId()+"_operations").toString();
            String curr_health_status=req.getParameter(i.getId()+"_health_status").toString();
            Patient curr_patient = new Patient(i.getId(),i.getName(),curr_procedures,curr_diagnosis,curr_medicines,curr_operations,curr_health_status);
            patientDao.update(curr_patient);
        }
        resp.sendRedirect("/patients");
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Configuration conf = new Configuration(Configuration.VERSION_2_3_31);
        conf.setDefaultEncoding(String.valueOf(StandardCharsets.UTF_8));
        conf.setDirectoryForTemplateLoading(new File("static-content"));
        HashMap<String, Object> data = new HashMap<>();
        patients = patientDao.getAll();
        prepare_list();
        data.put("patients",patients);

        int a =1;
        if(a==1){
            try (PrintWriter w = resp.getWriter()) {
                conf.getTemplate("patient_list_doctor.ftl").process(data, w);
            } catch (TemplateException x) {
                throw new RuntimeException(x);
            }
        }
        if(a==0){
            try (PrintWriter w = resp.getWriter()) {
                conf.getTemplate("patient_list_nurse.ftl").process(data, w);
            } catch (TemplateException x) {
                throw new RuntimeException(x);
            }
        }

    }
    private void prepare_list(){
        for (Patient i:this.patients){
            if(i.getDiagnosis()==null){i.setDiagnosis("-");}
            if(i.getProcedures()==null){i.setProcedures("-");}
            if(i.getOperations()==null){i.setOperations("-");}
            if(i.getMedicines()==null){i.setMedicines("-");}
            if(i.getHealth_status()==null){i.setHealth_status("-");}
        }
    }

}