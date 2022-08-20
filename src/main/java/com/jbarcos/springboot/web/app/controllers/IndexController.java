package com.jbarcos.springboot.web.app.controllers;

import com.jbarcos.springboot.web.app.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.Objects;


@Controller
@RequestMapping("/app")
public class IndexController {

    @GetMapping({"/index", "/", "/home"})
     public String index(Model model) {
        model.addAttribute("titulo", "Hola Spring Framework con Model");
        return "index";
    }

    @RequestMapping("/perfil")
    public String perfil(Model model) {

        Usuario usuario = new Usuario();
        usuario.setNombre("Jorge");
        usuario.setApellido("Barcos");

        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Perfil del usuario: ".concat(usuario.getNombre()));

        return "perfil";
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
