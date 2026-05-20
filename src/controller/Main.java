package controller;

import model.Juego;
import model.Jugador;

public class Main {

	public static void main(String[] args) {

		Jugador juagdor1= new Jugador("Jugador 1");
		Jugador juagdor2= new Jugador("Jugador 2");
		
		Juego juego=new Juego();
		
		juego.elegirTurno(juagdor1, juagdor2);

		
		
	}

}
