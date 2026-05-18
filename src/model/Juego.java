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
	
	// METODOS
	public void elegirTurno (Jugador jugador1, Jugador jugador2) {
		Random rd = new Random();
		int numeroAleatorio = rd.nextInt(2);
		
		tablero.imprimirTablero();

		if(numeroAleatorio == 0) {
			
			elegirFicha(jugador1);
			iniciarPartida(jugador1);
			iniciarPartida(jugador2);
			
		}else {
			elegirFicha(jugador2);
			iniciarPartida(jugador2);
			iniciarPartida(jugador1);

		}
	}
	
	public void elegirFicha(Jugador jugador) {
		int respuesta;
		Scanner sc=new Scanner(System.in);
		do {
			System.out.println("MENU");
			System.out.println("1.- X");
			System.out.println("2.- O");
			System.out.println("Elige (1-2)");
			respuesta=sc.nextInt();
		}while(respuesta < 1 && respuesta > 2);
		
		if (respuesta ==1) {
			jugador.setFicha("X");;
		}else {
			jugador.setFicha("O");;

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
		}while(fila < 1 && fila > 7);
		
		do {
			System.out.println("Dime un nº de columna:");
			columna = sc.nextInt();
		}while(columna < 1 && columna > 6);
		
		 tablero.sustituir(fila, columna, jugador);
		
	}
}
