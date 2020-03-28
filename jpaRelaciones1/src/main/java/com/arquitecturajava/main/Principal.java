package com.arquitecturajava.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.arquitecturajava.dominio.Categoria;
import com.arquitecturajava.dominio.Libro;

public class Principal {

	public static void main(String[] args) {

		// unidad de persistencia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Biblioteca");
		EntityManager em = emf.createEntityManager();

		String textoFecha = "20/01/2020";
		SimpleDateFormat ffecha = new SimpleDateFormat("d/M/yyyy");
		Date fecha = null;
		try {
			fecha = ffecha.parse(textoFecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		em.getTransaction().begin();

		// construccion de objetos
		Categoria categoria = new Categoria("javascript", "libros de Javascript");
		Libro libro = new Libro("4ABC", "Angular", "Ana", fecha, 4);
		Libro libro2 = new Libro("5ABC", "React", "Gema", fecha, 5);

		// Asignar relaciones
		libro.setCategoria(categoria);
		libro2.setCategoria(categoria);
		List<Libro> lista = new ArrayList<Libro>();
		lista.add(libro);
		lista.add(libro2);
		categoria.setLibros(lista);

		// persistir con JPA
		em.persist(categoria);
		em.persist(libro);
		em.persist(libro2);

		em.getTransaction().commit();
	}
}