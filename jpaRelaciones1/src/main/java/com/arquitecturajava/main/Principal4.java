package com.arquitecturajava.main;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.arquitecturajava.dominio.Libro;


public class Principal4 {

	public static void main(String[] args) {

		// unidad de persistencia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Biblioteca");
		EntityManager em = emf.createEntityManager();

		Libro l1 = em.find(Libro.class, "1Ab");
		Libro l2 = em.find(Libro.class, "6G");
		
		System.out.println(l1.esMasNuevo(l2));
		System.out.println(l2.esMasNuevo(l1));
		
	}
}