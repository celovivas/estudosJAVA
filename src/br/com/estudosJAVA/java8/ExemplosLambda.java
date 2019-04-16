package br.com.estudosJAVA.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ExemplosLambda {

	public static void main(String[] args) {
		
		// Podemos utilizar o lambda apenas com interfaces funcionais.
		// Interface funcional é uma interface que tem apenas 1 método abstrato, pois é este método que conseguimos "Resumir" com o lambda
		
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
		new Thread(r2).start();
		
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
		

		// Foreach original. 
		// o Método foreach recebe uma classe anonima. Na verdade é uma Interface funcional.
		System.out.println("Imprimir lista... Utilizando Lambda");
		list.forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer arg0) {
				System.out.println("ddd");				
			}
		});		
		
		// Utilizando lambda reduzindo o caso acima
		System.out.println("Imprimir lista... Utilizando Lambda");
		list.forEach(i -> System.out.println(i));
		
		
		System.out.println("Imprimir lista... Utilizando Lambda com mais de um comando (Apenas colocamos entre {}");
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
