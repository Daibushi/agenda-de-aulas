package com.star.start;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/eventos")
public class EventosController {
	@Autowired
	private Eventos eventos;
	
	@GetMapping
	public ModelAndView listar() {
		List<Evento> lista = eventos.findAll();
		
		ModelAndView modelAndView = new ModelAndView("eventos");
		modelAndView.addObject("eventos",lista);
		return modelAndView;
	}
}
