package model;

import java.sql.SQLException;

public class Jugador {

	//ATRIBUTOS
	private String nombre;
	private String password;
	private int partidasGanadas;
	private int partidasPerdidas;
	private int partidasEmpatadas;
	private String ficha;
	
	
	public Jugador(String nombre, String password) {
		this.nombre=nombre;
		this.password=password;
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
	
	//MÉTODOS
	
	public void registrarse() throws SQLException{
		DaoJugador.getInstance().insertUser(this);
	}
	
	public void mostrarRank() throws SQLException{
		DaoJugador.getInstance().selectRankin();
	}
	
	public void aniadirPartidaGanada() throws SQLException{
		DaoJugador.getInstance().actuPartidasGanadas(this);
	}
	
	public void aniadirPartidaPerdida() throws SQLException{
		DaoJugador.getInstance().actuPartidaPerdidas(this);
	}
	
	public void aniadirPartidaEmpatada() throws SQLException{
		DaoJugador.getInstance().actuPartidaEmpatada(this);
	}
}
