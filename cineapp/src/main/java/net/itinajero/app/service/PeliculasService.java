package net.itinajero.app.service;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import net.itinajero.app.model.Pelicula;

@Service
public class PeliculasService implements IPeliculasService{

	private List<Pelicula> lista = null;
	
	public PeliculasService() {
		System.out.println("Creando una instancia de la clase PeliculasService");
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		try {
			lista = new LinkedList<>();
			
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
			peli5.setEstado("Activa"); 
			
			lista.add(peli1);
			lista.add(peli2);
			lista.add(peli3);
			lista.add(peli4);
			lista.add(peli5);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	@Override
	public List<Pelicula> buscarTodas() {
		return lista;
	}

	@Override
	public Pelicula buscarPorId(int idPelicula) {
		
		for(Pelicula p : lista) {
			if(p.getId() == idPelicula) {
				return p;
			}
		}
		return null;
	}

	@Override
	public void insertar(Pelicula pelicula) {
		lista.add(pelicula);
		
	}

}
