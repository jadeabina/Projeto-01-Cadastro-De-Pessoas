package br.com.projeto01.jade;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		BancoDeDados bancoDeDados = new BancoDeDados();
		bancoDeDados.inserir();
		bancoDeDados.listar();

		}


	}


