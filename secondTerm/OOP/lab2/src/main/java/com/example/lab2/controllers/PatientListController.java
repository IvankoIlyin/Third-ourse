package com.example.lab2.controllers;


import com.example.lab2.model.Patient;
import com.example.lab2.model.User;
import com.example.lab2.service.PatientService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;


@Controller
@RequiredArgsConstructor
@Slf4j
public class PatientListController {

    private final PatientService patientService;

    @GetMapping("/list")
    public String patient_list(Model model) {
        model.addAttribute("patients", patientService.getAll());
        log.info("user on list");
        return "patient_list";
    }

    @GetMapping("/patient/{id}")
    public String patient_info(Model model, @PathVariable("id") Long id,HttpServletRequest request) {
        model.addAttribute("patient", patientService.getById(id).get());
        if(request.isUserInRole("doctor")){
            log.info("doctor on patient "+ patientService.getById(id).get().getName().toString());
            return "patient_doctor";}
        if(request.isUserInRole("nurse")){
            log.info("nurse on patient "+ patientService.getById(id).get().getName().toString());
            return "patient_nurse";}
        return "patient_list";
    }

    @PostMapping("/patientUpdNur/{id}")
    public RedirectView patient_updat_nurse(Model model, @PathVariable("id") Long id, @RequestParam("procedures") String procedures, @RequestParam("medicines")String medicines){
        Patient patient = patientService.getById(id).get();
        patient.setProcedures(procedures);
        patient.setMedicines(medicines);
        patientService.update(patient);
        log.info("nurse on update "+ patientService.getById(id).get().getName().toString());
        return new RedirectView("/list");
    }

    @PostMapping("/patientUpdDoc/{id}")
    public RedirectView patient_updat_doc(Model model, @PathVariable("id") Long id, @RequestParam("procedures") String procedures, @RequestParam("medicines") String medicines,@RequestParam("diagnosis") String diagnosis,@RequestParam("operations") String operations,@RequestParam("health_status") String health_status ){
        Patient patient = patientService.getById(id).get();
        patient.setProcedures(procedures);
        patient.setMedicines(medicines);
        patient.setDiagnosis(diagnosis);
        patient.setOperations(operations);
        patient.setHealth_status(health_status);
        patientService.update(patient);
        log.info("doctor on update "+ patientService.getById(id).get().getName().toString());
        return new RedirectView("/list");
    }





}
