package com.arquitecturajava.main;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.arquitecturajava.dominio.Categoria;
import com.arquitecturajava.dominio.Libro;


public class Principal5 {

	public static void main(String[] args) {

		// unidad de persistencia 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Biblioteca");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		Categoria c = em.find(Categoria.class, "programacion");
		List<Libro> lista = c.getLibros();
		for (Libro l :lista) {
			l.setCategoria(null);
		}
		em.remove(c);
		em.getTransaction().commit();
			
	}
}