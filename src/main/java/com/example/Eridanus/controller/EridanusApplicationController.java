package com.example.Eridanus.controller;

import com.example.Eridanus.dto.ObservationDTO;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.util.Locale;

@Controller
@EnableAutoConfiguration
public class EridanusApplicationController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/planets").setViewName("planets");
    }

    @GetMapping("/")
    public String showForm(ObservationDTO observationDTO, Model model) {
        return "main";
    }

    @PostMapping("/")
    public String postObservationForm(@Valid ObservationDTO observationDTO, BindingResult bindingResult) {
        System.out.println(bindingResult.getErrorCount());
        if (bindingResult.hasErrors()) {
            System.out.println("ABORTED");
            return "main";
        }

        return "redirect:/planets";
    }

}
