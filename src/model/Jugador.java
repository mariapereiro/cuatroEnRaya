package model;

public class Jugador {

	//ATRIBUTOS
	private String nombre;
	private String password;
	private int partidasGanadas;
	private int partidasPerdidas;
	private int partidasEmpatadas;
	private String ficha;
	
	
	public Jugador(String nombre) {
		this.nombre=nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPartidasGanadas() {
		return partidasGanadas;
	}
	public void setPartidasGanadas(int partidasGanadas) {
		this.partidasGanadas = partidasGanadas;
	}
	public int getPartidasPerdidas() {
		return partidasPerdidas;
	}
	public void setPartidasPerdidas(int partidasPerdidas) {
		this.partidasPerdidas = partidasPerdidas;
	}
	public int getPartidasEmpatadas() {
		return partidasEmpatadas;
	}
	public void setPartidasEmpatadas(int partidasEmpatadas) {
		this.partidasEmpatadas = partidasEmpatadas;
	}
	public String getFicha() {
		return ficha;
	}
	public void setFicha(String ficha) {
		this.ficha = ficha;
	}
	
	
	
}
