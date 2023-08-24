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

    @GetMapping("/hospitals")
    public String listHospitals(Model model) {
        model.addAttribute("hospitals", hospitalRepository.findAll());
        return "hospital/list";
    }
    
    // Add other CRUD operations here
}