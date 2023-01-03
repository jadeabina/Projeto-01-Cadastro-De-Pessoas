package br.com.projeto01.jade;

import java.sql.DriverManager;
import java.sql.Connection;

public class Conexao {

	//declaração de variaveis

	private String url;
	private String usuario;
	private String senha;

	public Connection getCon() {
		return con;
	}

	private Connection con;


	//COSTRUTOR
	Conexao() {
		url = "jdbc:postgresql://localhost:5432/postgres";
		usuario = "postgres";
		senha = "pandoraealfa2020";

		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conexão Realizada com Sucesso!!");
		} catch (Exception e) {
			e.printStackTrace( );


		}
	}

}





