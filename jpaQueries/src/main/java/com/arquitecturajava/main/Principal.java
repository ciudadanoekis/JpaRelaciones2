package com.arquitecturajava.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.arquitecturajava.dominio.Libro;

public class Principal {

	public static void main(String[] args) {
		
		//unidad de persistencia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Biblioteca");
		EntityManager em = emf.createEntityManager();
		
		//diseña una primera consulta orientada a objetos
		TypedQuery<Libro> consulta = em.createQuery("select l from Libro l", Libro.class);
		
		List<Libro> lista = consulta.getResultList();
		
		for (Libro autor : lista) {
			System.out.println(autor);
		}
	}

}
