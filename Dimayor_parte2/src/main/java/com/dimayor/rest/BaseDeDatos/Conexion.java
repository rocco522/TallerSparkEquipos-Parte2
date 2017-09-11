package com.dimayor.rest.BaseDeDatos;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dimayor.rest.Dimayor.Equipo;
import com.dimayor.rest.Dimayor.Servicio;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Conexion {

	public final static String PREF = "ejercici_";	
	public final static String URL = "jdbc:mysql://208.91.199.89:3306/"+PREF+"dimayor";
	public final static String USUARIO = PREF+"dimayor";
	public final static String CONTRASENA = ")yPs=OI_X$0z";
	public final static String CONTROLADOR = "com.mysql.jdbc.Driver";
	
	private static java.sql.Connection conexion;
	private Consulta consulta;
	private Servicio servicio;
	
	public Conexion() {
		super();
		consulta = new Consulta(this);
	}

	
	public static void conectarBD() throws ClassNotFoundException, SQLException{
		Class.forName(CONTROLADOR);
		conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
	}
	
	public ArrayList<Equipo> obtenerEquipos(){		
		return consulta.obtenerEquipos();
	}


	public static java.sql.Connection getConexion() {
		return conexion;
	}


	public static void setConexion(java.sql.Connection conexion) {
		Conexion.conexion = conexion;
	}
	
	public ArrayList<Equipo> obtenerLista(){
		return consulta.getEquipos();
	}
	
	public void modificarLista(ArrayList<Equipo> equipos){
		consulta.setEquipos(equipos);
	}


	public boolean modificarEquipo(Equipo equipo) {
		return consulta.modificarEquipo(equipo);
	}


	public boolean agregarEquipo(Equipo equipo) {
		return consulta.agregarEquipo(equipo);
	}


}
