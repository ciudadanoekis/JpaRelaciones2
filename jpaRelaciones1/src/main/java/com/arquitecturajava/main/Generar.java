package com.arquitecturajava.main;

import javax.persistence.Persistence;

public class Generar {

	public static void main(String[] args) {
		
		Persistence.generateSchema("Biblioteca", null);

	}

}
