package br.com.thiagocortes.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private static String user = "postgres";
	private static String pass = "admin";
	//private String host = "localhost";
	

	
	public static Connection getConection(){
		Connection con = null;
		try{
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/disciplinas",user,pass);
			System.out.println("Conxão realizada com sucesso!!");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return con;
	}
	

}
