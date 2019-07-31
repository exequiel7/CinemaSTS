package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.itinajero.app.model.Pelicula;
import net.itinajero.app.service.IPeliculasService;
import net.itinajero.app.util.Utileria;

@Controller
public class HomeController {
	@Autowired //Para inyectar una instancia en la variable de forma automatica. 
	private IPeliculasService servicePeliculas;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	@RequestMapping(value="/home", method=RequestMethod.GET) //peticiones tipo GET
	public String goHome(){
		return "home";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST) //Peticiones tipo POST
	public String buscar(@RequestParam("fecha") String fecha, Model model) { //vinculo con parametro fecha en el atributo name='fecha'
		List<String> listaFechas = Utileria.getNextDays(10);
		List<Pelicula> peliculas = servicePeliculas.buscarTodas();
		
		model.addAttribute("fechas", listaFechas);
		model.addAttribute("fechaBusqueda", fecha);
		model.addAttribute("peliculas", peliculas);
		System.out.println("Buscando todas las peliculas en exhibicion para las fechas: " + fecha);
		return "home";
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String mostrarPrincipal(Model model) {
		List<String> listaFechas = Utileria.getNextDays(10);
		
		List<Pelicula> peliculas = servicePeliculas.buscarTodas();
//		peliculas.add("Rapido y Furioso");
//		peliculas.add("El aro 2");
//		peliculas.add("Aliens");
		model.addAttribute("fechas", listaFechas);
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		model.addAttribute("peliculas", peliculas);
		
		return "home";
	}
	
//	@RequestMapping(value="/detail", method=RequestMethod.GET)
//	public String mostrarDetalle(Model model, @RequestParam("idMovie") int idPelicula, @RequestParam("fecha") String fecha) {
	@RequestMapping(value="/detail/{id}/{fecha}", method=RequestMethod.GET)
	public String mostrarDetalle(Model model, @PathVariable("id") int idPelicula, @PathVariable("fecha") String fecha) {	
		System.out.println("Buscando Horarios para la pelicula: " + idPelicula);
		System.out.println("Para la fecha: " + fecha);
		model.addAttribute("pelicula", servicePeliculas.buscarPorId(idPelicula));
		
//		TODO - BUSCAR en la base de datos los horarios
		
		return "detalle";
		
	}
	
}
