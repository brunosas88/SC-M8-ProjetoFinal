package com.aula04.banco.banco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HealthCheckController {

    @GetMapping("/health-check")
    public String healthCheck(Model modelo) {
        modelo.addAttribute("mensagem", "Aplication running!");
        return "healthCheck"; // Retornar com o mesmo nome do html
    }



}
