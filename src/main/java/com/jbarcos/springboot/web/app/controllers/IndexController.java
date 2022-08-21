package com.jbarcos.springboot.web.app.controllers;

import com.jbarcos.springboot.web.app.models.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;


@Controller
@RequestMapping("/app")
public class IndexController {

    // Con @Value aplicamos el valor que tenemos en el application.properties
    @Value("${texto.indexcontroller.index.titulo}")
    private String textoIndex;

    @Value("${texto.indexcontroller.perfil.titulo}")
    private String textoPerfil;

    @Value("${texto.indexcontroller.listar.titulo}")
    private String textoListar;

    @GetMapping({"/index", "/", "/home"})
     public String index(Model model) {
        model.addAttribute("titulo", textoIndex);
        return "index";
    }

    @RequestMapping("/perfil")
    public String perfil(Model model) {

        Usuario usuario = new Usuario();
        usuario.setNombre("Jorge");
        usuario.setApellido("Barcos");
        usuario.setEmail("jorge@correo.com");

        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));

        return "perfil";
    }

    @RequestMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("titulo", textoListar);

        return "listar";
    }

    // ModelAttribute genera un modelo que se puede usar en todas las vistas del controlador
    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios() {
        List<Usuario> usuarios = Arrays.asList(
                new Usuario("Jorge", "Barcos", "jorge@correo.com"),
                new Usuario("Julieta", "Diaz", "julieta@correo.com"),
                new Usuario("renzo", "Barcos", "renzo@correo.com"),
                new Usuario("Salem", "Barcos", "salem@correo.com"));

        return usuarios;
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
