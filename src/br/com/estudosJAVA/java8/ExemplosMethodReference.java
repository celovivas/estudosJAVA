/**
 * 
 */
package br.com.estudosJAVA.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author mvivasd
 *
 */
public class ExemplosMethodReference {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Modo antigo
		List<String> nomes = Arrays.asList("Marcelo", "Ana Paula", "Alícia", "Davi");
		for (String nome : nomes) {
			System.out.println(nome);
		}

		// Lambda
		nomes.forEach(nome -> System.out.println(nome));

		// Method Reference
		nomes.forEach(System.out::println);
		
		// Comparando strings todas em minusculos SEM Method Reference
		nomes.sort(Comparator.comparing(n -> n.toLowerCase()));
		// COM Method Reference:  Dado uma String, utilize o método toLowerCase dela.
		nomes.sort(Comparator.comparing(String::toLowerCase));
	}

}
