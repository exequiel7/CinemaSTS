package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.itinajero.app.model.Pelicula;
import net.itinajero.app.service.IPeliculasService;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {

	@Autowired //inyectar una instancia de nuestra clase de servicio
	private IPeliculasService servicePeliculas;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Pelicula> lista = servicePeliculas.buscarTodas();
		model.addAttribute("peliculas", lista);
		
		return "peliculas/listPelicula";
	}
	
	@GetMapping("/create")
	public String crear() {
		return "peliculas/formPelicula";
	}
	
	@PostMapping("/save")
	public String guardar(Pelicula pelicula, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			System.out.println("Existieron errores");
			return "peliculas/formPelicula";
		}
//		for(ObjectError error : result.getAllErrors()) {
//			System.out.println(error.getDefaultMessage());
//		}
		
		System.out.println("Recibiendo otro objeto pelicula: " + pelicula);
		
		System.out.println("Elementos en la lista ANTES de la insercion: " + servicePeliculas.buscarTodas().size());
		
		servicePeliculas.insertar(pelicula);
		
		System.out.println("Elementos en la lista DESPUES de la insercion: " + servicePeliculas.buscarTodas().size());
		
		attributes.addFlashAttribute("mensaje", "El registro fue guardado exitosamente.");
//		model.addAttribute("mensaje", "El registro fue guardado exitosamente.");
		//return "peliculas/formPelicula";
		return "redirect:/peliculas/index";
	}
	
	@InitBinder
	public void initBunder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	
}

