package br.com.projeto01.jade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

			BancoDeDados bancoDeDados = new BancoDeDados();
			showMenu(bancoDeDados);
		}

		private static void showMenu(BancoDeDados bancoDeDados){

			Scanner scanner = new Scanner(System.in);
			System.out.println(
					"\n\nEscolha uma opcao \n1: Incluir Pessoa \n2: Excluir Pessoa \n3: Atualizar Pessoa \n4: Listar Pessoas \n5: Sair"
			);

			int opcao = scanner.nextInt();

			executarOpcao(bancoDeDados, opcao);
		}

		private static void executarOpcao(BancoDeDados bancoDeDados,int opcao){

			switch (opcao) {

				case 1: bancoDeDados.inserir();showMenu(bancoDeDados);
				case 2: bancoDeDados.deletar();showMenu(bancoDeDados);
				case 3: bancoDeDados.update();showMenu(bancoDeDados);
				case 4: bancoDeDados.listar();showMenu(bancoDeDados);
				case 5:  break;
				default: showMenu(bancoDeDados);
			}

		}



	}


