package com.star.start;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		List<Integer> diasSemana = Arrays.asList(0,1,2,3,4,5,6);
		
		List<Evento> lista = eventos.findAll();
		
		Map<Integer, List<Evento>> calendario = new HashMap<Integer, List<Evento>>();
		diasSemana.forEach(day -> {
			List<Evento> buffer = new ArrayList<Evento>();
			IntStream.range(0, 23).forEachOrdered(n -> {
				Evento evento = new Evento();
				evento.setNome("Data em aberto");
				buffer.add(evento);
			});
			calendario.put(day, buffer);
		});
		
		ModelAndView modelAndView = new ModelAndView("eventos");
		modelAndView.addObject("eventos",lista);
		modelAndView.addObject("dias",diasSemana);
		modelAndView.addObject("calendario",calendario);
		return modelAndView;
	}
	
	@GetMapping("/list")
	public String array(Model model) {
		String[] continents = {
	          "Africa", "Antarctica", "Asia", "Australia", 
	          "Europe", "North America", "Sourth America"
	        };
	        
	        model.addAttribute("continents", continents);

	        return "continents";
		
	}
}
