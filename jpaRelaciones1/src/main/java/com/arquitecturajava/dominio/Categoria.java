package com.arquitecturajava.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Categorias")
public class Categoria {
	@Id
	private String nombre;
	private String descripcion;
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.PERSIST)
	private List<Libro> libros = new ArrayList<Libro>();

	public Categoria(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Categoria() {
		super();
	}

	public Categoria(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public void addLibro(Libro l) {
		this.libros.add(l);
		l.setCategoria(this);
	}
	
	public void addLibros(Libro ...libros) {
		for (Libro l : libros) {
			
			this.libros.add(l);
			l.setCategoria(this);
		}
	}

	public void removeLibro(Libro l) {
		this.libros.remove(l);
		l.setCategoria(null);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

}
