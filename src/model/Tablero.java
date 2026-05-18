package model;

public class Tablero {
	
	// ATRIBUTOS
	private String tablero[][] = new String [6][7];
	
	
	// METODOS
	public void imprimirTablero() {
		for(int i = 0 ; i < tablero.length; i++) {
			for(int x = 0; x < tablero[i].length; x++) {
				if(tablero[i][x] == null) {
					System.out.print("|");
					System.out.print("_|");
				}
				
				
			}
			System.out.println("");
 		}
	}
	
	
}
