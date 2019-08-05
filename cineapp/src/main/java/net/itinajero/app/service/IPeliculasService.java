package net.itinajero.app.service;

import java.util.List;

import net.itinajero.app.model.Pelicula;

public interface IPeliculasService {
	List<Pelicula> buscarTodas();
	void insertar(Pelicula pelicula);
	Pelicula buscarPorId(int idPelicula);
}
