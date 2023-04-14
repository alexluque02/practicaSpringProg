package com.salesianostriana.dam.e01holamundo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // Se va a llamar cuando haya una petición dicha por GetMapping
public class ControladorSaludo {

	// @GetMapping ("welcome")Atiende a esta ruta en el navegador
	@GetMapping({ "/", "welcome" }) // Atiende a las dos
	public String darBienvenida(@RequestParam(name = "nombre", required = false, defaultValue = "Mundo") String nombre,
			Model model) {
		model.addAttribute("nombre", nombre);
		return "index";// archivo HTML sin la extensión HTML
	}

	@GetMapping("/saludo2")
	public String darBienvenida2(Model model) {// No le damos requestParam porque no queremos parametros
		model.addAttribute("persona", new Persona("Alex", "Luque"));
		return "saludoPersonalizado";
	}

	@GetMapping("/saludo3")
	public String welcome3(Model model) {
		model.addAttribute("saludo", "Hola Mundo");
		model.addAttribute("mensaje", "¡Se me está haciendo    largo el proyecto final!");
		model.addAttribute("url", "https://triana.salesianos.edu");
		return "saludoYEnlace";
	}
}
