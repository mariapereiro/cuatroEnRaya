package model;

import java.util.Scanner;

public class Inicio {
	
	private Juego juego;
	private Jugador jugador1;
	private Jugador jugador2;
	
	public Inicio() {
		this.juego=new Juego();
		this.jugador1=new Jugador("Jugador 1");
		this.jugador2=new Jugador("Jugador 2");

	}
	
	public void menu() throws InterruptedException {
		Scanner sc= new Scanner(System.in);
		int respuesta;
		
		String GREEN = "\u001B[32m";
		String ANSI_RESET = "\u001B[0m";

		
		System.out.println("===============================================");
		System.out.println("|               MENU PRINCIPAL                |");
		System.out.println("|                                             |");
		System.out.println("| 1.- Jugar partida                           |");
		System.out.println("| 2.- Ver INSTRUCCIONES                       |");
		System.out.println("| 3.- Mostrar RANKING                         |");
		System.out.println("| 4.- Salir                                   |");
		System.out.println("| Elige una OPCIÓN (1, 2, 3, 4)               |");
		System.out.println("|                                             |");
		System.out.println("===============================================");
		
		do{
			System.out.println("Introduce una OPCIÓN: ");
			respuesta=sc.nextInt();
		}while(respuesta < 1 || respuesta > 4);
		
		if(respuesta == 1) {
			juego.elegirTurno(jugador1, jugador2);
			System.out.println("");
			menu();
		}else if(respuesta == 2) {
			System.out.println(GREEN+"OBJETIVO"+ANSI_RESET);
			System.out.println("Ser el primero en alinear 4 fichas consecutivas (horizontal, vertical o diagonal)." );
			Thread.sleep(1500);
			
			System.out.println();
			
			System.out.println(GREEN+"TABLERO"+ANSI_RESET);
			System.out.println("Cuadrícula de 6 filas por 7 columnas.");
			Thread.sleep(1500);

			System.out.println();

			System.out.println(GREEN+"INICIO"+ANSI_RESET);
			System.out.println("El tablero se vacía y el primer turno se decide de forma aleatoria.");
			Thread.sleep(1500);

			System.out.println();

			System.out.println(GREEN+"DINÁMICA"+ANSI_RESET);
			System.out.println("Los jugadores alternan turnos para elegir una columna.");
			System.out.println("La ficha cae por gravedad a la posición libre más baja.");
			Thread.sleep(1500);

			System.out.println();

			System.out.println(GREEN+"VALIDACIÓN"+ANSI_RESET);
			System.out.println("Si la columna está llena o el dato es incorrecto, el sistema pide repetir el movimiento.");
			Thread.sleep(1500);

			System.out.println();

			System.out.println(GREEN+"FIN DE LA PARTIDA"+ANSI_RESET);
			System.out.println("Termina por victoria (al conectar las 4 fichas) o por empate (si se llena el tablero sin ganador).");
			
			System.out.println("");
			
			menu();
		}
		

	}
	
	

}
