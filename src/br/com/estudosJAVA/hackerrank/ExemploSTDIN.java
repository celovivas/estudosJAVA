/**
 * 
 */
package br.com.estudosJAVA.hackerrank;

import java.util.Scanner;

/**
 * @author mvivasd
 *
 */
public class ExemploSTDIN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite um texto: ");
		String myString = scanner.next();
		System.out.println("Digite um número: ");
		int myInt = scanner.nextInt();
		scanner.close();

		System.out.println("myString is: " + myString);
		System.out.println("myInt is: " + myInt);	

	}

}
