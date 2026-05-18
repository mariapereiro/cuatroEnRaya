package model;

import java.util.Random;

public class Juego {

	
	// ATRIBUTOS
	private int fila;
	private int columna;
	private int turno;
	private Tablero tablero;
	private Jugador jugador1;
	private Jugador jugador2;
	
	// METODOS
	public void elegirTurno (Jugador jugador1, Jugador jugador2) {
		Random rd = new Random();
		int numeroAleatorio = rd.nextInt(2);
		if(numeroAleatorio == 0) {
			iniciarPartida(jugador1);
			iniciarPartida(jugador2);
			
		}else {
			iniciarPartida(jugador2);
			iniciarPartida(jugador1);

		}
	}
	
	
	public void iniciarPartida(Jugador jugador) {
		tablero.imprimirTablero();
	}
}
