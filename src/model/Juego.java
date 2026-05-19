package model;

import java.util.Random;
import java.util.Scanner;

import model.Tablero;

public class Juego {

	
	
	// ATRIBUTOS
	private int turno;
	private Tablero tablero;
	private Jugador jugador1;
	private Jugador jugador2;
	
	// CONSTRUCTOR
	public Juego() {
		this.tablero = new Tablero();
	}
	
	// METODOS
	
	
	public void elegirTurno (Jugador jugador1, Jugador jugador2) {
		Random rd = new Random();
		int numeroAleatorio = rd.nextInt(2);

		if(numeroAleatorio == 0) {
			elegirFicha(jugador1, jugador2);
			iniciarPartida(jugador1);
			iniciarPartida(jugador2);
			
		}else {
			elegirFicha(jugador1, jugador2);
 			iniciarPartida(jugador2);
			iniciarPartida(jugador1);

		}
	}
	
	public void elegirFicha(Jugador jugador1, Jugador jugador2) {
		int respuesta;
		Scanner sc=new Scanner(System.in);
		do {
			System.out.println("MENU");
			System.out.println("1.- X");
			System.out.println("2.- O");
			System.out.println("Elige (1-2)");
			respuesta=sc.nextInt();
		}while(respuesta < 1 || respuesta > 2);
		
		if (respuesta ==1) {
			jugador1.setFicha("X");
			jugador2.setFicha("O");

			
		}else {
			jugador1.setFicha("O");
			jugador2.setFicha("X");


		}
 		
	}
	
	public void iniciarPartida(Jugador jugador) {
		Scanner sc=new Scanner(System.in);
		int fila;
		int columna;
			
		tablero.imprimirTablero();
		
		do {
			System.out.println("Dime un nº de fila:");
			fila = sc.nextInt();
		}while(fila < 0 || fila > 6);
		
		do {
			System.out.println("Dime un nº de columna:");
			columna = sc.nextInt();
		}while(columna < 0 || columna > 5);
		
		 tablero.sustituir(fila, columna, jugador);
		
	}
}
