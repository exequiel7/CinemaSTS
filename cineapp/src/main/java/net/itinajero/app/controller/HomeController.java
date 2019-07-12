package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.itinajero.app.model.Pelicula;

@Controller
public class HomeController {

	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String goHome(){
		return "home";
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String mostrarPrincipal(Model model) {
		List<Pelicula> peliculas = getLista();
		
//		peliculas.add("Rapido y Furioso");
//		peliculas.add("El aro 2");
//		peliculas.add("Aliens");
		model.addAttribute("peliculas", peliculas);
		
		return "home";
	}
	
	@RequestMapping(value="/detail")
	public String mostrarDetalle(Model model) {
		String tituloPelicula = "Rapidos y furiosos";
		int duracion = 136;
		double precioEntrada = 50;
		
		model.addAttribute("titulo", tituloPelicula);
		model.addAttribute("duracion", duracion);
		model.addAttribute("precio", precioEntrada);
		
		return "detalle";
		
	}
	
	// Metodo para generar una lista de objetos de Modelo (Pelicula)
	private List<Pelicula> getLista(){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		List<Pelicula> listaPeliculas = null;
		
		try {
			listaPeliculas = new LinkedList<>();
			
			Pelicula peli1 = new Pelicula();
			peli1.setId(1);
			peli1.setTitulo("Power Rangers");
			peli1.setDuracion(120);
			peli1.setClasificacion("B");
			peli1.setGenero("Aventura");
			peli1.setFechaEstreno(formatter.parse("15-07-2019"));
			
			Pelicula peli2 = new Pelicula();
			peli2.setId(1);
			peli2.setTitulo("La Bella y la Bestia");
			peli2.setDuracion(132);
			peli2.setClasificacion("A");
			peli2.setGenero("Infantil");
			peli2.setFechaEstreno(formatter.parse("20-07-2019"));
			
			Pelicula peli3 = new Pelicula();
			peli3.setId(1);
			peli3.setTitulo("Contratiempo");
			peli3.setDuracion(106);
			peli3.setClasificacion("B");
			peli3.setGenero("Thriller");
			peli3.setFechaEstreno(formatter.parse("25-07-2019"));
			
			listaPeliculas.add(peli1);
			listaPeliculas.add(peli2);
			listaPeliculas.add(peli3);
			
			return listaPeliculas;
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return null;
		}
	}
	
}
