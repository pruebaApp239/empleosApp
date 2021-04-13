package org.edgar.eduardo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Especificaciones JPA

@Entity
@Table(name="categorias")
public class Categoria {
        //variables de clase
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre; //nombre de la categoria
	private String descripcion; //descripcion de la categoria
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	
	
}
