package br.com.projeto01.jade;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		PersistenciaPessoa persistenciaPessoa = new PersistenciaPessoa();


			System.out.println("Digite seu nome:");
			var nome= (scanner.nextLine());


			System.out.println("Digite a sua data de nascimento: ");
			var nascimento= (scanner.nextLine());


			System.out.println("Digite o seu cpf: ");
			var cpf= (scanner.nextLine());

			persistenciaPessoa.executaSQL("insert into pessoa (nome,nascimento,cpf) values ('"+nome+"','"+nascimento+"','"+cpf+"')");


		System.out.println("cadastrado com sucesso");


		}


	}


