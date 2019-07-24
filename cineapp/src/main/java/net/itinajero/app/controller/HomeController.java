package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.itinajero.app.model.Pelicula;
import net.itinajero.app.util.Utileria;

@Controller
public class HomeController {
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	@RequestMapping(value="/home", method=RequestMethod.GET) //peticiones tipo GET
	public String goHome(){
		return "home";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST) //Peticiones tipo POST
	public String buscar(@RequestParam("fecha") String fecha, Model model) { //vinculo con parametro fecha en el atributo name='fecha'
		List<String> listaFechas = Utileria.getNextDays(10);
		List<Pelicula> peliculas = getLista();
		
		model.addAttribute("fechas", listaFechas);
		model.addAttribute("fechaBusqueda", fecha);
		model.addAttribute("peliculas", peliculas);
		System.out.println("Buscando todas las peliculas en exhibicion para las fechas: " + fecha);
		return "home";
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String mostrarPrincipal(Model model) {
		List<String> listaFechas = Utileria.getNextDays(10);
		
		List<Pelicula> peliculas = getLista();
//		peliculas.add("Rapido y Furioso");
//		peliculas.add("El aro 2");
//		peliculas.add("Aliens");
		model.addAttribute("fechas", listaFechas);
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		model.addAttribute("peliculas", peliculas);
		
		return "home";
	}
	
//	@RequestMapping(value="/detail/{id}/{fecha}", method=RequestMethod.GET)
//	public String mostrarDetalle(Model model, @PathVariable("id") int idPelicula, @PathVariable("fecha") String fecha) {
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String mostrarDetalle(Model model, @RequestParam("idMovie") int idPelicula, @RequestParam("fecha") String fecha) {
		
		System.out.println("Buscando Horarios para la pelicula: " + idPelicula);
		System.out.println("Para la fecha: " + fecha);
//		TODO - BUSCAR en la base de datos los horarios
		
		
		
		
//		String tituloPelicula = "Rapidos y furiosos";
//		int duracion = 136;
//		double precioEntrada = 50;
//		
//		model.addAttribute("titulo", tituloPelicula);
//		model.addAttribute("duracion", duracion);
//		model.addAttribute("precio", precioEntrada);
		
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
			//imagen = "cinema.png"
			
			Pelicula peli2 = new Pelicula();
			peli2.setId(2);
			peli2.setTitulo("La Bella y la Bestia");
			peli2.setDuracion(132);
			peli2.setClasificacion("A");
			peli2.setGenero("Infantil");
			peli2.setFechaEstreno(formatter.parse("20-07-2019"));
			peli2.setImagen("bella.png");
			
			Pelicula peli3 = new Pelicula();
			peli3.setId(3);
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
