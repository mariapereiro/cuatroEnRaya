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
			System.out.println("_______________________________________");
			System.out.println("Empieza juagando "+jugador1.getNombre());
			System.out.println("_______________________________________");
			System.out.println();
			elegirFicha(jugador1, jugador2);
			iniciarPartida(jugador1);
			iniciarPartida(jugador2);
			
		}else {
			System.out.println("_______________________________________");
			System.out.println("Empieza juagando "+jugador2.getNombre());
			System.out.println("_______________________________________");
			System.out.println();
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
		System.out.println("============================");
		System.out.println("| TURNO "+jugador.getNombre()+"          |");
		System.out.println("============================");
		tablero.imprimirTablero();
		
		do {
			System.out.println("_____________________________________");
			do {
				System.out.println("Dime un nº de fila:");
				fila = sc.nextInt();
			}while(fila < 0 || fila > 5);
		
			do {
				System.out.println("Dime un nº de columna:");
				columna = sc.nextInt();
			}while(columna < 0 || columna > 6);
			System.out.println();
		}while(tablero.celdaOcupada(fila, columna));
		
		tablero.sustituir(fila, columna, jugador);
		System.out.println();

		
	}
}
