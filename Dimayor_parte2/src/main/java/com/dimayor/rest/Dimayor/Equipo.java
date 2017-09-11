package com.dimayor.rest.Dimayor;


public class Equipo {
	
	private String id;
	private String nombre;
	private String anioFundacion;
	private int numeroTitulos;
	
	public Equipo(String id, String nombre, String anioFundacion, int numeroTitulos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.anioFundacion = anioFundacion;
		this.numeroTitulos = numeroTitulos;
	}	
	

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getAnioFundacion() {
		return anioFundacion;
	}
	
	public void setAnioFundacion(String anioFundacion) {
		this.anioFundacion = anioFundacion;
	}
	
	public int getNumeroTitulos() {
		return numeroTitulos;
	}
	
	public void setNumeroTitulos(int numeroTitulos) {
		this.numeroTitulos = numeroTitulos;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	

}
