package br.com.teste;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Exercicio03 {

	public static void main(String[] args) {
		
		LinkedHashMap<String, Double> faturamentoDiario = new LinkedHashMap<>();
		ArrayList<String> diasComMediaMaior = new ArrayList<>();
		String dia = "";
		double valor = 0.0;
		double valorMaior = 0.0;
		double valorMenor = 999999999.99;
		double mediaDeVendas = 0.0;
		String diaValorMaior = "";
		String diaValorMenor = "";
		double somaDasVendas = 0.0;
		int contador = 0;
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dc = dbf.newDocumentBuilder();
			
			try {
				Document doc = dc.parse("exercicio03.xml");
				
				NodeList listaRow = doc.getElementsByTagName("row");
				for (int i = 0; i < listaRow.getLength(); i++) {
					
					Node noRow = listaRow.item(i);
					if (noRow.getNodeType() == Node.ELEMENT_NODE) {
						Element elementoRowMain = (Element) noRow;
						NodeList listaFilhosRow = elementoRowMain.getChildNodes();
						
						for (int j = 0; j < listaFilhosRow.getLength(); j++) {
							
							Node nofilhoRow = listaFilhosRow.item(j);
							
							if (nofilhoRow.getNodeType() == Node.ELEMENT_NODE) {
								
								Element elementonoRow = (Element) nofilhoRow;
								
								switch (elementonoRow.getTagName()) {
									
								case "dia":
									dia = elementonoRow.getTextContent();
									break;
								case "valor":
									String valorString = elementonoRow.getTextContent();
									valor = Double.parseDouble(valorString);
									break;
								}
								faturamentoDiario.put(dia, valor);
							}				
						}	
					}	
				}
			} catch (SAXException | IOException e) {
				e.printStackTrace();
			}
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		for (Map.Entry<String, Double> listando : faturamentoDiario.entrySet()) {
			
			if (listando.getValue() > valorMaior) {
				valorMaior = listando.getValue();
				diaValorMaior = listando.getKey();
			}
			if (listando.getValue() < valorMenor && listando.getValue() != 0.0) {
				valorMenor = listando.getValue();
				diaValorMenor = listando.getKey();
			}
			if (listando.getValue() != 0.0) {
				contador = contador + 1;
				somaDasVendas = somaDasVendas + listando.getValue();
				mediaDeVendas = somaDasVendas / contador;
			}

		}
		for (Map.Entry<String, Double> listandoDiasComMediaSuperior : faturamentoDiario.entrySet()) {	
			
			if (listandoDiasComMediaSuperior.getValue() > mediaDeVendas) {
				diasComMediaMaior.add(listandoDiasComMediaSuperior.getKey());
			}
		}
		
		System.out.println("***Relação de Faturamento***");
		System.out.printf("O menor valor faturado foi de R$ %.2f no dia %s.", valorMenor, diaValorMenor);
		System.out.println();
		System.out.printf("O maior valor faturado foi de R$ %.2f no dia %s.", valorMaior, diaValorMaior);
		System.out.println();
		System.out.printf("Os dias com a média de faturamento maior que R$ %.2f foram:", mediaDeVendas);
		System.out.println();
		System.out.println(diasComMediaMaior);
		
	}
}
