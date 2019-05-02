/**
 * 
 */
package br.com.estudosJAVA.java8;

import java.util.Arrays;
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
	}

}
