package model;

public class Tablero {
	
	// ATRIBUTOS
	private String tablero[][] = new String [6][7];
	
	// METODOS
	public void imprimirTablero() {
		for(int i = 0 ; i < tablero.length; i++) {
			for(int x = 0; x < tablero[i].length; x++) {
				if(tablero[i][x] == null) {
 					System.out.print("|_|");
				}else {
					System.out.print("|"+tablero[i][x]+"|");
					
				}
				
				
			}
			System.out.println("");
 		}
	}
	
	public void sustituir(int fila, int columna, Jugador jugador) {
		if(tablero[fila][columna] == null) {
			tablero[fila][columna] = jugador.getFicha();
		}
	}
	
	
}
