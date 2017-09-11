package com.dimayor.rest.BaseDeDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dimayor.rest.Dimayor.Equipo;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Consulta {
	
	public final static String TABLA = "equipos";
	
	private Conexion con;
	private ArrayList<Equipo> equipos;
	
	private static java.sql.Statement st;
	private ResultSet resultado;

	public Consulta(Conexion con) {
		this.con = con;
		
		equipos = new ArrayList<Equipo>();
	}

	public ArrayList<Equipo> obtenerEquipos() {
		
		try {
			st = con.getConexion().createStatement();
			
			String consulta = "SELECT * FROM " + TABLA;
			
			String id = "";
			String nombre = "";
			String anioFundacion = "";
			int numeroTitulos = 0;
			
			resultado = st.executeQuery(consulta);
			
			while(resultado.next()){
				id = resultado.getString(2);
				nombre = resultado.getString(3);
				anioFundacion = resultado.getString(4);
				numeroTitulos = Integer.parseInt(resultado.getString(5));
				
				System.out.println(id+nombre+anioFundacion+numeroTitulos);
				
				equipos.add(new Equipo(id, nombre, anioFundacion, numeroTitulos));
			}
			
			st.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return equipos;
	}
	
	public boolean modificarEquipo(Equipo equipo) {
		try {
			st = con.getConexion().createStatement();
			String id = equipo.getId();
			String nombre = equipo.getNombre();
			String anioFundacion = equipo.getAnioFundacion();
			int numeroTitulos = equipo.getNumeroTitulos();
			
			String consulta = "UPDATE "+ TABLA +
			" SET `nombre`=\""+nombre+"\",`anioFundacion`=\""+anioFundacion+"\",`numeroTitulos`="+numeroTitulos+
			" WHERE `id_2` = "+equipo.getId();
			
			st.execute(consulta);
			
			modificarEquipoEnArray(equipo);
			
			st.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}

	public void modificarEquipoEnArray(Equipo equipo) {
		String nId = equipo.getId();
		for(int i=0; i<equipos.size(); i++){
			if( equipos.get(i).getId().equals(nId) ){
				equipos.get(i).setNombre(equipo.getNombre());
				equipos.get(i).setAnioFundacion(equipo.getAnioFundacion());
				equipos.get(i).setNumeroTitulos(equipo.getNumeroTitulos());
			}
		}	
	}
	
	public ArrayList<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(ArrayList<Equipo> equipos) {
		this.equipos = equipos;
	}

	public boolean agregarEquipo(Equipo equipo) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
