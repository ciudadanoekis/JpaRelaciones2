package com.arquitecturajava.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.arquitecturajava.dominio.Libro;

public class Principal2Insertar {

	public static void main(String[] args) {
		
		//unidad de persistencia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Biblioteca");
		EntityManager em = emf.createEntityManager();
		
		//no funciona el formateador de fecha!!!
		String textoFecha = "1/01/2020";
		SimpleDateFormat ffecha = new SimpleDateFormat("d/M/yyyy");
		Date fecha = null;
		try {
			fecha = ffecha.parse(textoFecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Libro l1 = new Libro("2A", "JPA","Ana", fecha, 3);
		
		em.getTransaction().begin();
		em.persist(l1);
		em.getTransaction().commit();

	}

}
