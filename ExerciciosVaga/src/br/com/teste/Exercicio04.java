package br.com.teste;

import java.util.HashMap;
import java.util.Map;

public class Exercicio04 {

	public static void main(String[] args) {
		
		HashMap<String, Double> faturamento = new HashMap<>();
		
		faturamento.put("SP    ", 67836.43);
		faturamento.put("RJ    ", 36678.66);
		faturamento.put("MG    ", 29229.88);
		faturamento.put("ES    ", 27165.48);
		faturamento.put("OUTROS", 19849.53);
		
		Double valorTotal = 180762.98;
		System.out.println("***Tabela de representação das vendas mensais da distribuidora***");
		System.out.println();
		for (Map.Entry<String, Double> i : faturamento.entrySet()) {
			Double valorComPorcentagem = (i.getValue() / valorTotal) * 100;
			String formatador = String.format("%s representa %.2s%% das vendas.", i.getKey(), valorComPorcentagem);
			System.out.println(formatador);
		}
	}		
}

