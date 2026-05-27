package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Scanner;

import bbdd.Jugador;

public class Inicio {

	private Jugador jugador1;
	private Jugador jugador2;

	public Inicio() {

	}
	
	public static String sha256(String mensaje) {
		
		try {
			
			//Es una clase de Java
			MessageDigest sha= MessageDigest.getInstance("SHA-256");
			
			//convierte a bytes
			byte [] digest =sha.digest(mensaje.getBytes());
			
			StringBuilder hexString = new StringBuilder();
			
			for(byte b : digest) {
				hexString.append(String.format("%02x", b));
			}
			
			return hexString.toString();
			
		}catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	
	//Menu CREAR USUARIO
	public void crearUsuario() throws SQLException{
		Scanner sc=new Scanner(System.in);
 
		System.out.println("╔═══════════════════════════╗");
		System.out.println("| CREA TU USUARIO JUGADOR 1 |");
		System.out.println("╚═══════════════════════════╝");
		System.out.println();

		System.out.println("Nombre de USUARIO");
		String usuario=sc.nextLine();
		
		System.out.println();

		System.out.println("Contraseña:");
		String password=sc.nextLine();
		sha256(password);
		
		jugador1=new Jugador(usuario, sha256(password));
		jugador1.registrarse();
		
		System.out.println();
		
		System.out.println("╔═══════════════════════════╗");
		System.out.println("| CREA TU USUARIO JUGADOR 2 |");
		System.out.println("╚═══════════════════════════╝");
		System.out.println();

		System.out.println("Nombre de USUARIO");
		String usuario2=sc.nextLine();
		
		System.out.println();

		System.out.println("Contraseña:");
		String password2=sc.nextLine();
		
		jugador2=new Jugador(usuario2, sha256(password2));
		jugador2.registrarse();

	}

	public void menu() throws InterruptedException, SQLException {
		Scanner sc= new Scanner(System.in);
		int respuesta;
		
		String GREEN = "\u001B[32m";
		String ANSI_RESET = "\u001B[0m";
		
		do {
			System.out.println("╔══════════════════════════════════════════════╗");
			System.out.println("║               MENU PRINCIPAL                 ║");
			System.out.println("║                                              ║");
			System.out.println("║ 1.- Jugar partida                            ║");
			System.out.println("║ 2.- Ver INSTRUCCIONES                        ║");
			System.out.println("║ 3.- Mostrar RANKING                          ║");
			System.out.println("║ 4.- Salir                                    ║");
			System.out.println("║                                              ║");
			System.out.println("╚══════════════════════════════════════════════╝");
			
		
			do{
				System.out.println("Elige una OPCIÓN (1, 2, 3, 4)");
				respuesta=sc.nextInt();
			}while(respuesta < 1 || respuesta > 4);
		
			if(respuesta == 1) {
				Juego juego = new Juego();
				
				juego.elegirTurno(jugador1, jugador2);
				System.out.println("");
 			
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
			
 			}else if(respuesta == 3) {
 				jugador1.mostrarRank();
 			}
		}while(respuesta !=4);
		

	}
	
	

}
