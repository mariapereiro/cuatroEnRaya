package controller;

import java.sql.SQLException;

import model.Inicio;
import model.Juego;
import model.Jugador;

public class Main {

	public static void main(String[] args) throws InterruptedException, SQLException {
		
		/*
		Jugador juagdor1= new Jugador("Jugador 1");
		Jugador juagdor2= new Jugador("Jugador 2");
		
		Juego juego=new Juego();
		
		juego.elegirTurno(juagdor1, juagdor2);
		*/
		Inicio inicio= new Inicio();
		
		try {
			inicio.crearUsuario();
			
			inicio.menu();
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		
	

		
		
	}

}
