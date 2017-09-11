package com.dimayor.rest.Dimayor;

import java.util.ArrayList;

public class Servicio 
{

	private ArrayList<Equipo> equipos;

	public Servicio(){
		iniciarEquipos();
	}

	public void iniciarEquipos(){
		equipos = new ArrayList<Equipo>();

		equipos.add(new Equipo("01", "Deportivo Cali", "1912", 9));
		equipos.add(new Equipo("02", "Atlético Nacional", "1947", 16));
		equipos.add(new Equipo("03", "Millonarios", "1939", 14));
		equipos.add(new Equipo("04", "Santa Fe", "1941", 9));
		equipos.add(new Equipo("05", "América de Cali", "1927", 13));
		equipos.add(new Equipo("06", "Atlético Junior", "1924", 7));
		equipos.add(new Equipo("07", "Independiente Medellín", "1913", 6));
		equipos.add(new Equipo("08", "Once Caldas", "1961", 4));
		equipos.add(new Equipo("09", "Deportes Tolima", "1954", 1));
		equipos.add(new Equipo("10", "Boca Juniors de Cali", "1939", 0));
		equipos.add(new Equipo("11", "Deportivo Pasto", "1949", 1));
		equipos.add(new Equipo("12", "La Equidad", "1982", 0));
		equipos.add(new Equipo("13", "Deportes Quindío", "1951", 1));
		equipos.add(new Equipo("14", "Cúcuta Deportivo", "1924", 1));
		equipos.add(new Equipo("15", "Boyacá Chicó", "2002", 1));
		equipos.add(new Equipo("16", "Unión Magdalena", "1953", 1));
		equipos.add(new Equipo("17", "Atlético Huila", "1990", 0));
		equipos.add(new Equipo("18", "Real Cartagena", "1971", 0));
		equipos.add(new Equipo("19", "Atlético Bucaramanga", "1949", 0));
		equipos.add(new Equipo("20", "Rionegro Águilas", "2008", 0));

		System.out.println("Equipos iniciados");
	}

	public ArrayList<Equipo> getAllEquipos(){
		return equipos;
	}

	public void eliminarEquipo(String id){
		String nId = id.substring(3, 5);
		for(int i=0; i<equipos.size(); i++){
			if( equipos.get(i).getId().equals(nId) )
				equipos.remove(i);
		}
	}

	public Equipo getEquipo(String id){

		Equipo eq = null;
		String nId = id.substring(3, 5);

		for(int i=0; i<equipos.size(); i++){
			if( equipos.get(i).getId().equals(nId) )
				eq = equipos.get(i);
		}

		return eq;
	}

	public void agregarEquipo(String id, String nombre, String fundacion, int estrellas){
		equipos.add(new Equipo(id, nombre, fundacion, estrellas));
	}

	public void modificarEquipo(String id, String nombre, String fundacion, int estrellas){
		String nId = id.substring(3, 5);
		for(int i=0; i<equipos.size(); i++){
			if( equipos.get(i).getId().equals(nId) ){
				equipos.get(i).setNombre(nombre);
				equipos.get(i).setAnioFundacion(fundacion);
				equipos.get(i).setNumeroTitulos(estrellas);
			}
		}
	}

	public boolean agregarEquipo(Equipo equipo) {
		return equipos.add(equipo);
	}

	public boolean eliminarEquipo(Equipo equipo) {
		return equipos.remove(equipo);

	}

	public void modificarEquipo(Equipo equipo) {
		String nId = equipo.getId();
		for(int i=0; i<equipos.size(); i++){
			if( equipos.get(i).getId().equals(nId) ){
				equipos.get(i).setNombre(equipo.getNombre());
				equipos.get(i).setAnioFundacion(equipo.getAnioFundacion());
				equipos.get(i).setNumeroTitulos(equipo.getNumeroTitulos());
			}
		}
		
	}
}
