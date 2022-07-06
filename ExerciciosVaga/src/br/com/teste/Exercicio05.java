package br.com.teste;

import java.util.Scanner;

public class Exercicio05 {

	public static void main(String[] args) {
		
		String palavra;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Escreva uma palavra: ");
		palavra = teclado.next();
		
		for (int i = palavra.length() - 1; i >= 0 ; i--) {
			System.out.print(palavra.charAt(i));
		}
		teclado.close();
	}
}

