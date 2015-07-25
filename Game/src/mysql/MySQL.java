package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQL {
		public static Connection connection;

		public static synchronized void openConnection() {
			try {
				connection = DriverManager.getConnection("jbdc:mysql://localhost:3306/server", "root", "password");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		public static void updateGame(String uuid, int gems){
			try {
			    String query = "DELETE game WHERE player=" + uuid + ";";
			
				PreparedStatement p = connection.prepareStatement(query);
				p.execute();
				p.close();
			} catch (SQLException e){
				e.printStackTrace();
			}	
			try {
			    String query = "INSERT INTO game VALUES(?, ?);";
			
				PreparedStatement p = connection.prepareStatement(query);
				p.setString(1, uuid);
				p.setInt(2, gems);
				p.execute();
				p.close();
			} catch (SQLException e){
				e.printStackTrace();
			}	
		}
		
		public static void insertGame(String uuid, int gems){	
			try {
			    String query = "INSERT INTO game VALUES(?, ?);";
			
				PreparedStatement p = connection.prepareStatement(query);
				p.setString(1, uuid);
				p.setInt(2, gems);
				p.execute();
				p.close();
			} catch (SQLException e){
				e.printStackTrace();
			}	
		}
		
		@SuppressWarnings("finally")
		public static List<String> getGame() {
			List<String> temp = new ArrayList<>();

			String query = "SELECT player FROM game;";

			try {
				ResultSet res = connection.prepareStatement(query).executeQuery();

				while (res.next()) {
					temp.add(res.getString("player"));
				}

				res.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
			    return temp;
			}
		}
}
