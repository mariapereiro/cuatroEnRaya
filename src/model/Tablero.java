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

	public boolean empate() {
		for (int i = 0; i < tablero.length; i++) {
			for (int x = 0; x < tablero[i].length; x++) {
				if (tablero[i][x] == null) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	//Comprobar Horizontal
	public boolean horizontal(Jugador jugador) {
		for(int i=0; i < tablero.length; i++) { //fila
			for(int x=0; x < tablero[i].length-3; x++) { //columna
				if(tablero[i][x] != null 
					&& tablero[i][x].equals(tablero[i][x+1]) 
					&& tablero[i][x].equals(tablero[i][x+2]) 
					&& tablero[i][x].equals(tablero[i][x+3]) 
					&& tablero[i][x].equals(jugador.getFicha())) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	//Comprobar Vertical
		public boolean vertical(Jugador jugador) {
			for(int i=0; i < tablero.length-3; i++) {
				for(int x=0; x < tablero[i].length; x++) {
					if(tablero[i][x] != null 
						&& tablero[i][x].equals(tablero[i+1][x]) 
						&& tablero[i][x].equals(tablero[i+2][x]) 
						&& tablero[i][x].equals(tablero[i+3][x]) 
						&& tablero[i][x].equals(jugador.getFicha())) {
						return true;
					}
				}
			}
			return false;
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
