package com.dimayor.rest.Api;


import com.dimayor.rest.Dimayor.Equipo;
import com.dimayor.rest.Dimayor.Servicio;

import static spark.Spark.*;

import com.google.gson.Gson;

public class ApiRest {

	public static Servicio servicio = new Servicio();

	public static void main(String[] args){

		Gson gson = new Gson();

		get("/obtenerEquipos", (req, res) -> {
			res.type("application/json");
			return servicio.getAllEquipos();
		}, gson ::toJson);
		
		get("/obtener/:id", (req, res) -> {
			res.type("application/json");
			return servicio.getEquipo(req.params(":id"));
		}, gson ::toJson);
		
		post("/agregar", (req, res) -> {
			res.type("application/json");
			Equipo equipo = gson.fromJson(req.body(), Equipo.class);
			System.out.println("Nombre "+equipo.getNombre());
			return servicio.agregarEquipo(equipo);
		}, gson ::toJson);

		delete("/eliminar/:id", (req, res) -> {
			res.type("application/json");
			servicio.eliminarEquipo(req.params(":id"));
			return gson.toJson("Equipo eliminado con éxito");
		}, gson ::toJson);

		put("/modificar/:id", (req, res) -> {
			res.type("application/json");
			res.type("application/json");
			Equipo equipo = gson.fromJson(req.body(), Equipo.class);
			System.out.println("Nombre "+equipo.getNombre());
			servicio.modificarEquipo(equipo);
			return gson.toJson("Equipo eliminado con éxito");
		}, gson ::toJson);
	}
}
