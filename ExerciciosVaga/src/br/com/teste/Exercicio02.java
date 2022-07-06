package br.com.teste;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercicio02 {

	public static void main(String[] args) {
		
		int numeroUm = 0, numeroDois = 1, soma = 0, valorDigitado = 0, ultimoValor = 0;
		
		Scanner teclado = new Scanner(System.in);
		ArrayList <Integer> sequenciaFibonacci = new ArrayList<>();
		
		System.out.println("Escreva um número e eu te direi se ele faz parte da sequência de Fibonacci ou não: ");
		valorDigitado = teclado.nextInt();
		System.out.println("***Sequência Fibonacci***");
		System.out.println(numeroUm);
		System.out.println(numeroDois);
		for (int i = 0; i <= sequenciaFibonacci.size(); i++) {
				soma = numeroUm + numeroDois;
				sequenciaFibonacci.add(soma);
				numeroUm = numeroDois;
				numeroDois = soma;	
				ultimoValor = sequenciaFibonacci.get(i);
				System.out.println(sequenciaFibonacci.get(i));
				if (sequenciaFibonacci.get(i) >= valorDigitado) {
					break;
				}
		}
		System.out.println();
		if (ultimoValor == valorDigitado) {
				System.out.println("O valor " + valorDigitado + " pertence a sequência Fibonacci.");
		}
		if (ultimoValor != valorDigitado) {
			System.out.println("O valor " + valorDigitado + " não pertence a sequência Fibonacci.");
		}	
		teclado.close();
	}
}