package br.com.estudosJAVA.java8;

import java.util.Arrays;
import java.util.List;

public class ExemplosLambda {

	public static void main(String[] args) {
		
		exemplosTrhead();
		
		exemplosCollection();

	}
	
	public static void exemplosTrhead(){
		
// 		Normal
		Runnable r = new Runnable() {
			public void run() {
				System.out.println("Thread com classe interna. Modo tradicional!");
			}
		};
		new Thread(r).start();
		
		//Thread com Lambda
		Runnable r2 = () -> System.out.println("Thread com função lambda!");
		new Thread(r).start();
		
		//Thread com Lambda Ex 2
		new Thread(
				() -> System.out.println("Expressão lambda passada por parâmetro")
				).start();
	}
	
	
	public static void exemplosCollection(){
		
		List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		System.out.println("Imprimir lista... Modo tracicional");
		for(Integer n: list) {
		    System.out.println(n);
		}
		
		
		System.out.println("Imprimir lista... Utilizando Lambda");
		list.forEach(i -> System.out.println(i));
		
		
		System.out.println("Imprimir lista... Utilizando Lambda com mais de um comando");
		list.forEach(i -> {
				if (i % 2 == 0){
					System.out.println("Número par: " + i);	
				}
			});
		
		list.forEach(i -> {
			System.out.println("Número inteiro do número dividido por 2: " + i / 2);	
		});		
		
		
	}

}
