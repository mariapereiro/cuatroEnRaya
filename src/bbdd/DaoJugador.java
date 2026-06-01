package bbdd;

import java.sql.*;

public class DaoJugador {
	
	//ATRIBUTOS
	private Connection conn = null;
	private static DaoJugador instance = null;
	
	
	//MÉTODOS
	
	public DaoJugador() throws SQLException {
		conn = DbConnection.getConnection();
	}
	
	public static DaoJugador getInstance() throws SQLException {
		
		if(instance == null) {
			instance = new DaoJugador();
		}
		return instance;
	}
	
	
	//Método INSERT 
	
	public void insertUser(Jugador jugador) throws SQLException {
		
		String insertSQL="INSERT INTO jugadores (nombre, password) VALUES (?, ?)";
		
		//Consulta dinámica
		PreparedStatement ps=conn.prepareStatement(insertSQL);
		
		ps.setString(1, jugador.getNombre());
		ps.setString(2, jugador.getPassword());
		
		int jugadoresInsertados = ps.executeUpdate();
		
		if(jugadoresInsertados > 0) {
			System.out.println("Te has registrado EXITOSAMENTE");
		}else {
			System.out.println("ERROR para registrarte");
		}
		
		ps.close();
	}
	
	 
	
	//Método RANKING
	public void selectRankin() throws SQLException{
		
		//Consulta estática
		String selectRankingData ="SELECT * FROM jugadores ORDER BY partidasGanadas DESC";
		Statement statementSelect = conn.createStatement();
		
		ResultSet resultData=statementSelect.executeQuery(selectRankingData);
		
		imprimirRankin(resultData);
		
		statementSelect.close();
	}
	
	public void imprimirRankin(ResultSet resultData) throws SQLException{
		int countData =0;
		
		while(resultData.next()) {
			String nombre=resultData.getString(2);
			int partidasGanadas=resultData.getInt(4);
			
			countData++;
			
			System.out.println("___________________________________________");
			System.out.println("| - Usuario: " + nombre);
			System.out.println("| - Partidas Ganadas: " + partidasGanadas);
			System.out.println("|__________________________________________");
			System.out.println();
			
		}
	}
	
	
	//Partidas Ganadas
	public void actuPartidasGanadas(Jugador jugador) throws SQLException{
		
		String updateSql="UPDATE jugadores SET partidasGanadas = ? WHERE nombre = ?";
		
		//Consulta dinámica
		PreparedStatement statementUpdate = conn.prepareStatement(updateSql);
		
		statementUpdate.setInt(1, jugador.getPartidasGanadas());
		statementUpdate.setString(2, jugador.getNombre());
		
		int registrosUpdated = statementUpdate.executeUpdate();
		
		if(registrosUpdated > 0) {
			System.out.println("+1 Partida Ganada");
		}else {
			System.out.println("No se pudo actualizar tus partidas ganadas");
		}
		
		statementUpdate.close();
		
	}
	
	//Partida Perdida
	public void actuPartidaPerdidas(Jugador jugador) throws SQLException{
		String updateSql="UPDATE jugadores SET partidasPerdidas = ? WHERE nombre = ?";
		
		//Consulta dinámica
		PreparedStatement statementUpdate = conn.prepareStatement(updateSql);
		
		statementUpdate.setInt(1, jugador.getPartidasPerdidas());
		statementUpdate.setString(2, jugador.getNombre());
		
		int registrosUpdated = statementUpdate.executeUpdate();
		
		if(registrosUpdated > 0) {
			System.out.println("+1 Partida Perdida");
		}else {
			System.out.println("No se pudo actualizar tus partidas perdidas");
		}
		
		statementUpdate.close();
		
	}
	
	//Partida empatada
	
	public void actuPartidaEmpatada(Jugador jugador) throws SQLException{
			String updateSql="UPDATE jugadores SET partidasEmpatadas = ? WHERE nombre = ?";
			
			//Consulta dinámica
			PreparedStatement statementUpdate = conn.prepareStatement(updateSql);
			
			statementUpdate.setInt(1, jugador.getPartidasEmpatadas());
			statementUpdate.setString(2, jugador.getNombre());
			
			int registrosUpdated = statementUpdate.executeUpdate();
			
			if(registrosUpdated > 0) {
				System.out.println("+1 Partida Empatada");
			}else {
				System.out.println("No se pudo actualizar tus partidas empatadas");
			}
			
			statementUpdate.close();
			
		}

}
