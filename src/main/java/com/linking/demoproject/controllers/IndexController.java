package com.linking.demoproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("titulo","Soy el titulo");
        model.addAttribute("saludo","Este es mi saludo");
        model.addAttribute("show",false);
//        List<String> series=null;//List.of("The mentalist","The Black List","The Flash");
//        model.addAttribute("series",series);
        return "index";
    }

    @GetMapping(value = "/index-mv")
    public ModelAndView indexMV(ModelAndView mv){
        mv.addObject("titulo","Titulo ModelAndView");
        mv.addObject("saludo","Hola mundo desde Java");
        mv.addObject("show",true);
//        List<String> series=List.of("The mentalist", "The Black List","The Flash");
//        mv.addObject("series",series);
        mv.setViewName("index");
        return mv;
    }

    @ModelAttribute("series")
    public List<String> getSeries(){
        return List.of("The mentalist", "The Black List","The Flash","Gotham","The Last Of Us");
    }

    @RequestMapping(value = "/index-req-mapping", method = RequestMethod.GET)
    public  String indexRequestMapping(Model model){
        model.addAttribute("titulo","Soy el titulo");
        model.addAttribute("saludo","Este es mi saludo");
        return "index";
    }
}
