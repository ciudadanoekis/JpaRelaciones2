package com.arquitecturajava.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.arquitecturajava.dominio.Libro;


public class PrinciparOrderBy {

	public static void main(String[] args) {
		
		//unidad de persistencia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Biblioteca");
		EntityManager em = emf.createEntityManager();
		
		//diseña una primera consulta orientada a objetos
		TypedQuery<Object[]> consulta = em.createQuery("select l.precio, count(l.precio) from Libro l group by l.precio", Object[].class);
		
		List<Object[]> lista = consulta.getResultList();
		
		for (Object[] subLista : lista) {
			//
			System.out.println("tipo de precio "+ subLista[0]+ " numero de elementos "+subLista[1]);
		}
	}

}
