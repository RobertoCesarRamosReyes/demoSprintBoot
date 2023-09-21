package com.linking.demoproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParametrosControllers {

    @GetMapping("/parametros")
    public String parametros(@RequestParam(defaultValue = "") String val,@RequestParam(defaultValue = "Sin nombre") String nombre, Model model){
        model.addAttribute("titulo","Parametros");
        model.addAttribute("parametro",val);
        model.addAttribute("nombre",nombre);
        return "parametros";
    }
}
