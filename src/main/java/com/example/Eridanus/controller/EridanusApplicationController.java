package com.example.Eridanus.controller;

import com.example.Eridanus.dto.ObservationDTO;

import com.example.Eridanus.service.ObservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Controller
@EnableAutoConfiguration
public class EridanusApplicationController implements WebMvcConfigurer {

    @Autowired
    ObservationService observationService;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/planets").setViewName("planets");
        registry.addViewController("/observation_info").setViewName("observation_info");
    }

    @GetMapping("/")
    public String showForm(ObservationDTO observationDTO, Model model) {
        return "main";
    }

    @PostMapping("/")
    public String postObservationForm(@Valid ObservationDTO observationDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("ABORTED");
            System.out.println("ERRORS FOUND: " + bindingResult.getErrorCount());
            return "main";
        }
        observationService.addObservation(observationDTO);
        return "redirect:/planets";
    }

    @GetMapping("/observation_info")
    public String showObservations(Model model) {
        model.addAttribute("observations", observationService.getAllObservations());
        return "observation_info";
    }

}
