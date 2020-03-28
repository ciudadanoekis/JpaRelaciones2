package com.arquitecturajava.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.arquitecturajava.dominio.Libro;

public class PrinciparFuncion {

	public static void main(String[] args) {
		
		//unidad de persistencia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Biblioteca");
		EntityManager em = emf.createEntityManager();
		
		//diseña una primera consulta orientada a objetos
		TypedQuery<String> consulta = em.createQuery("select distinct upper(l.autor) from Libro l", String.class);
		
		List<String> lista = consulta.getResultList();
		
		for (String unlibro : lista) {
			System.out.println(unlibro);
		}
	}

}
