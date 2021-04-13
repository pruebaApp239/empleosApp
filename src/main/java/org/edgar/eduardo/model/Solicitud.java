package org.edgar.eduardo.model;

import java.time.LocalDate;

public class Solicitud {
	//variables de clase
	private Integer id;
	private LocalDate fecha; //fecha en la que aplica para la oferta
	private String comentarios;
	private String archivo; //nombre del archivo (PDF, etc)
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public String getArchivo() {
		return archivo;
	}
	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
	
	@Override
	public String toString() {
		return "Solicitud [id=" + id + ", fecha=" + fecha + ", comentarios=" + comentarios + ", archivo=" + archivo
				+ "]";
	}	
}