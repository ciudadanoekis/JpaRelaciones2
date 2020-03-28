package com.arquitecturajava.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.arquitecturajava.dominio.Libro;

public class PrincipalWhere {

	public static void main(String[] args) {
		
		//unidad de persistencia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Biblioteca");
		EntityManager em = emf.createEntityManager();
		
		//diseña una primera consulta orientada a objetos con where
		TypedQuery<Libro> consulta = em.createQuery("select l from Libro l where l.autor=:autor", Libro.class);
		consulta.setParameter("autor", "Seyia");
		List<Libro> lista = consulta.getResultList();
		
		for (Libro unlibro : lista) {
			System.out.println(unlibro);
		}
	}

}
