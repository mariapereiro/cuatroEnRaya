package model;

public class Tablero {

	// ATRIBUTOS
	private String tablero[][] = new String[6][7];

	// METODOS
	public void imprimirTablero() {
		for (int i = 0; i < tablero.length; i++) {
			for (int x = 0; x < tablero[i].length; x++) {
				if (tablero[i][x] == null) {
					System.out.print("|_|");
				} else {
					System.out.print("|" + tablero[i][x] + "|");

				}
			}
			System.out.println("");
		}
	}

	public boolean comprobarTablero() {
		for (int i = 0; i < tablero.length; i++) {
			for (int x = 0; x < tablero[i].length; x++) {
				if (tablero[i][x] == null) {
					return false;
				}
			}
		}
		return true;
	}
	

	public int comprobarPosicion(int columna, Jugador jugador) {
		for (int i = 5; i >= 0; i --) {
 			if(tablero[i][columna] == null) {
 				return i;
 			} 
 		}
		
		return -1;
 	}
	
	public void colocarFicha(int fila, int columna, Jugador jugador) {
		this.tablero[fila][columna]=jugador.getFicha();
	}


}
