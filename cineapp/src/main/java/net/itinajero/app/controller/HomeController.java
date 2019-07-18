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
			peli2.setImagen("bella.png");
			//imagen = "cinema.png"
			
			Pelicula peli3 = new Pelicula();
			peli3.setId(1);
			peli3.setTitulo("Contratiempo");
			peli3.setDuracion(106);
			peli3.setClasificacion("B");
			peli3.setGenero("Thriller");
			peli3.setFechaEstreno(formatter.parse("25-07-2019"));
			peli3.setImagen("contratiempo.png");
			
			Pelicula peli4 = new Pelicula();
			peli4.setId(4);
			peli4.setTitulo("Kong La Isla Calavera");
			peli4.setDuracion(118);
			peli4.setClasificacion("B");
			peli4.setGenero("Accion y Aventuras");
			peli4.setFechaEstreno(formatter.parse("30-07-2019"));
			peli4.setImagen("kong.png");
			peli4.setEstado("Inactiva"); //Pelicula Inactiva
			
			Pelicula peli5 = new Pelicula();
			peli5.setId(5);
			peli5.setTitulo("Life: Vida Inteligente");
			peli5.setDuracion(104);
			peli5.setClasificacion("B");
			peli5.setGenero("Drama");
			peli5.setFechaEstreno(formatter.parse("15-07-2019"));
			peli5.setImagen("estreno5.png");
			peli5.setEstado("activa"); 
			
			listaPeliculas.add(peli1);
			listaPeliculas.add(peli2);
			listaPeliculas.add(peli3);
			listaPeliculas.add(peli4);
			listaPeliculas.add(peli5);
			
			return listaPeliculas;
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return null;
		}
	}
	
}
