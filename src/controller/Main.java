package controller;

import model.Juego;
import model.Jugador;

public class Main {

	public static void main(String[] args) {

		Jugador juagdor1= new Jugador();
		Jugador juagdor2= new Jugador();
		
		Juego juego=new Juego();
		
		juego.elegirTurno(juagdor1, juagdor2);

		
		
	}

}
