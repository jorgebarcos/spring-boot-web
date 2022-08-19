package com.jbarcos.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.Objects;


@Controller
public class IndexController {

    @GetMapping({"/index", "/", "/home"})
     public String index(Model model) {
        model.addAttribute("titulo", "Hola Spring Framework con Model");
        return "index";
    }

    /******OTRAS FORMAS DE RETORNAR DATOS A LA VISTA******/
    /*public ModelAndView index(ModelAndView mv) {
        mv.addObject("titulo", "Hola Spring Framework con ModelAndView");
        mv.setViewName("index");
        return mv;
    }*/

    /*public String index(Map<String, Object> map) {
        map.put("titulo", "Hola Spring Framework con Map");
        return "index";
    }*/

    /*public String index(ModelMap model) {
        model.addAttribute("titulo", "Hola Spring Framework con ModelMap");
        return "index";
    }*/



}
