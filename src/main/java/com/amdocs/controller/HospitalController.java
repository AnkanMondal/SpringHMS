package com.amdocs.controller;

import com.amdocs.model.Hospital;
import com.amdocs.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HospitalController {
    @Autowired
    private HospitalRepository hospitalRepository;
    private patientRepository patientRepository;

    @GetMapping("/hospitals")
    public String listHospitals(Model model) {
        model.addAttribute("hospitals", hospitalRepository.findAll());
        return "hospital/list";
    }
    
    @GetMapping("/addPatient")
    public String addPatient(@ModelAttribute Patient patient) {
        patientRepository.save(patient);
        return "redirect:/";
    }

    @GetMapping("/updatePatient/{id}")
    public String updatePatient(@ModelAttribute Patient patient) {
        Hospital hospital = hospitalRepository.findById(id).orElse(null);
        model.addAttribute("hospital", hospital);
        model.addAttribute("patients", patientRepository.findAll());
        patientRepository.save(patient);
        return "updatePatient";
    }

    @GetMapping("/deletePatient/{id}")
    public String deletePatient(@PathVariable Long id) {
        patientRepository.deleteById(id);
        return "redirect:/";
    }
}
