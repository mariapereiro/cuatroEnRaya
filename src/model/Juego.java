package model;

import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

import bbdd.Jugador;
import model.Tablero;


public class Juego {

	// ATRIBUTOS
	private Tablero tablero;	


	// CONSTRUCTOR
	public Juego() {
		this.tablero = new Tablero();
	}

	// METODOS
	
	public void turno(Jugador jugador1, Jugador jugador2) throws SQLException {
		System.out.println("_______________________________________");
		System.out.println("Empieza juagando " + jugador1.getNombre());
		System.out.println("_______________________________________");
		System.out.println();

		elegirFicha(jugador1, jugador2);

		do {
			iniciarPartida(jugador1);
			
			if(!tablero.empate() && !tablero.horizontal(jugador1) && !tablero.vertical(jugador1) && !tablero.diagonalDerecha(jugador1) && !tablero.diagonalIzquierda(jugador1)) {
				
				iniciarPartida(jugador2);
			}
		} while (!tablero.empate() && !tablero.horizontal(jugador1) && !tablero.horizontal(jugador2) 
				&& !tablero.vertical(jugador1) && !tablero.vertical(jugador2)
				&& !tablero.diagonalDerecha(jugador1) && !tablero.diagonalDerecha(jugador2)
				&& !tablero.diagonalIzquierda(jugador1) && !tablero.diagonalIzquierda(jugador2));
		
		if(tablero.empate()) {
			tablero.imprimirTablero();
			System.out.println();
			System.out.println("EMPATE");
			jugador1.setPartidasEmpatadas(jugador1.getPartidasEmpatadas() +1);
			jugador1.aniadirPartidaEmpatada();
			
			jugador2.setPartidasEmpatadas(jugador2.getPartidasEmpatadas() +1);
			jugador2.aniadirPartidaEmpatada();
			
 		}
		
		if(tablero.horizontal(jugador1) || tablero.vertical(jugador1) || tablero.diagonalDerecha(jugador1) || tablero.diagonalIzquierda(jugador1)) {
			tablero.imprimirTablero();
			System.out.println();
			System.out.println("HA GANADO "+jugador1.getNombre()+"!!!");
		
			jugador1.setPartidasGanadas(jugador1.getPartidasGanadas() +1);
			jugador1.aniadirPartidaGanada();
			
			jugador2.setPartidasPerdidas(jugador2.getPartidasPerdidas() +1);
			jugador2.aniadirPartidaPerdida();
		}
		if(tablero.horizontal(jugador2) || tablero.vertical(jugador2) || tablero.diagonalDerecha(jugador2) || tablero.diagonalIzquierda(jugador2)) {
			tablero.imprimirTablero();
			System.out.println();
			System.out.println("HA GANADO "+jugador2.getNombre()+"!!!");
			
			jugador2.setPartidasGanadas(jugador2.getPartidasGanadas() +1);
			jugador2.aniadirPartidaGanada();
			
			jugador1.setPartidasPerdidas(jugador1.getPartidasPerdidas()+1);
			jugador1.aniadirPartidaPerdida();
		}
	}
	
 
	
	public void elegirFicha(Jugador jugador1, Jugador jugador2) {
		int respuesta;
		String RED = "\u001B[91m";
		String BLUE = "\u001B[94m";
		
		//Resetear el color
		String ANSI_RESET = "\u001B[0m";


		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("MENU");
			System.out.println("1.- X");
			System.out.println("2.- O");
			System.out.println("Elige FICHA (1-2)");
			respuesta = sc.nextInt();
		} while (respuesta < 1 || respuesta > 2);

		if (respuesta == 1) {
			jugador1.setFicha(BLUE+"X" + ANSI_RESET);
			jugador2.setFicha(RED +"O"+ ANSI_RESET);

		} else {
			jugador1.setFicha(RED +"O"+ ANSI_RESET);
			jugador2.setFicha(BLUE+ "X" + ANSI_RESET);

		}

	}
	
	
	public void elegirTurno(Jugador jugador1, Jugador jugador2) throws SQLException {
		Random rd = new Random();
		int numeroAleatorio = rd.nextInt(2);

		if (numeroAleatorio == 0) {
			turno(jugador1, jugador2);
 
		} else {
			turno(jugador2, jugador1);
 
		}
	}

	public void iniciarPartida(Jugador jugador) {
		Scanner sc = new Scanner(System.in);
		int columna;
		int fila;
		do {
			System.out.println("============================");
			System.out.println("| TURNO " + jugador.getNombre() + "          |");
			System.out.println("============================");
			tablero.imprimirTablero();

			System.out.println("_____________________________________");

			do {
				System.out.println("Dime un nº de columna:");
				columna = sc.nextInt();
			} while (columna < 1 || columna > 7);
			columna--;

			System.out.println();
			// Fila = -1 significa que esa columna está llena por lo que tengo que
			// seleccionar otra columna
			fila = tablero.comprobarPosicion(columna, jugador);
			
			if (fila == -1) {
				System.out.println("Columna llena, seleccione otra");
				System.out.println("");
			} else {
				tablero.colocarFicha(fila, columna, jugador);
 
			}
		} while (fila == -1);

		System.out.println();

	}
}
