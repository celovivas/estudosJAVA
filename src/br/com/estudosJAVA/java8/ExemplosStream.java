/**
 * 
 */
package br.com.estudosJAVA.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import br.com.estudosJAVA.java8.model.Pergunta;
import br.com.estudosJAVA.java8.model.Resposta;

/**
 * @author Marcelo
 *
 */
public class ExemplosStream {
	
	static List<Pergunta> perguntas;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		criarPerguntas();
		
		exemplosComparatorComLambda();	

		// Stream: O conceito é tipo, me devolva todos os tipos de métodos possíveis que eu vejo os que vou usar.
		// O stream vai fazer uma cópia da collection e vai utilizar a cópia. Ou seja, ela não muda a ordem da collection original.
		// Caso você queira a collection resultante, utiliza-se o Collector.collect no final.
		exemplosComStream();

	}
	
	private static void exemplosComStream(){
		// Utiliza o predicado, e também é uma classe anonima, logo tb podemos usar o lambda
		perguntas.stream()
			.filter(p -> p.getRespostas().size() >= 2)
			.forEach(p -> System.out.println(p.toString()));

//		Ex 2
		perguntas.stream()
		.filter(p -> p.getRespostas().size() >= 2)
		.filter(p -> p.getAutor().equalsIgnoreCase("Marcelo"))
		.forEach(p -> System.out.println(p.toString()));
//		perguntas.forEach(p -> System.out.println(p.toString()));

//		Ex 3
//		Utilizando o map: Ele vai mapear e nos retornar um map
		perguntas.stream()
		.filter(p -> p.getRespostas().size() >= 2)
		.map(p -> p.getRespostas().size())
		.forEach(p -> System.out.println(p.toString()));
		
//		Ex 4
//		Retornando uma lista baseada nos filtros utilizados.
//		Neste caso retorna uma lista de Integer devido ao map utilizado que retorna uma lista de inteiros.		
		List<Integer> lista = perguntas.stream()
		.filter(p -> p.getRespostas().size() >= 2)
		.map(p -> p.getRespostas().size())
		.collect(Collectors.toList());
		
		lista.forEach(i -> System.out.println(i));		
		
	}
	
	private static void exemplosComparatorComLambda(){
		
		// Novo foreach
		perguntas.forEach(new Consumer<Pergunta>() {
			@Override
			public void accept(Pergunta t) {
				System.out.println(t.getPergunta());
			}
		});
		
		// utilizando lambda. Ex1 - Utilizando mais de um comando no método implementado
		perguntas.forEach(
			(Pergunta t) -> {
				System.out.println(t.getPergunta());
				System.out.println(t.getAutor());
		});
		
		// utilizando lambda. Ex2
		perguntas.forEach((Pergunta t) -> System.out.println(t.getPergunta()));
		
		// utilizando lambda. Ex3
		perguntas.forEach((p) -> System.out.println(p.getPergunta()));
		
		
		
		// Ordenando a collection utilizando a qtde de respostas que tem no java 7
		Collections.sort(perguntas, new Comparator<Pergunta>() {
			@Override
			public int compare(Pergunta p1, Pergunta p2) {
				if (p1.getRespostas().size() < p2.getRespostas().size()){
					return -1;
				}else if (p1.getRespostas().size() > p2.getRespostas().size()){
						return 1;
				}else{
					return 0;
				}
			}
		});
		
		perguntas.forEach(p -> System.out.println(p.toString()));
		
		// JAVA 8
		// Agora existe um metodo sort em todas as listas.
		perguntas.sort(new Comparator<Pergunta>() {
			@Override
			public int compare(Pergunta p1, Pergunta p2) {
				if (p1.getRespostas().size() < p2.getRespostas().size()){
					return -1;
				}else if (p1.getRespostas().size() > p2.getRespostas().size()){
						return 1;
				}else{
					return 0;
				}
			}
		});
		
		// Como o Comparator também é uma interface funcional, podemos utilizar o lambda
		// Ex 1
		perguntas.sort(
			(Pergunta p1, Pergunta p2) -> {
				if (p1.getRespostas().size() < p2.getRespostas().size()){
					return -1;
				}else if (p1.getRespostas().size() > p2.getRespostas().size()){
						return 1;
				}else{
					return 0;
				}
			}
		);
		
		// Ex 2
		perguntas.sort( (p1, p2) -> {
				if (p1.getRespostas().size() < p2.getRespostas().size()){
					return -1;
				}else if (p1.getRespostas().size() > p2.getRespostas().size()){
						return 1;
				}else{
					return 0;
				}
			}
		);
		
		// Ex 3
		// A classe Integer já faz a comparação entre inteiros. Então podemos simplificar ainda mais... Basicamente ele já faz os ifs de comparação.
		perguntas.sort( (p1, p2) -> {
				return Integer.compare(p1.getRespostas().size(), p2.getRespostas().size());
			}
		);
		
		// Ex 4
		// Simplificando...
		perguntas.sort( (p1, p2) -> Integer.compare(p1.getRespostas().size(), p2.getRespostas().size()));		

		// Ex 5
		// Utilizando agora o novo método comparing do Comparator
		// Passamos o objeto e o critério de comparação que ele se vira
		perguntas.sort(Comparator.comparing(p -> p.getRespostas().size()));		
		
		perguntas.forEach(p -> System.out.println(p.toString()));
		
		// Ex 6
		// Mudando o criterio de comparação...
		perguntas.sort(Comparator.comparing(p -> p.getId()));		
		
		perguntas.forEach(p -> System.out.println(p.toString()));		
		
		
	}

	private static void criarPerguntas(){
		
		perguntas = new ArrayList<Pergunta>();

		Pergunta p1 = new Pergunta(1, "Quais as cores da bandeira do Brasil", "Marcelo");
		
		p1.getRespostas().add(new Resposta(1, "Estou em dúvida"));
		p1.getRespostas().add(new Resposta(2, "Azul, verde e amarela"));
		p1.getRespostas().add(new Resposta(3, "Azul, verde e amarela e branca"));
		
		Pergunta p2 = new Pergunta(2, "Quem descobriu o Brasil", "Pedro");
		
		p2.getRespostas().add(new Resposta(1, "João Neto e Frederico"));
		p2.getRespostas().add(new Resposta(2, "Pero Vaz de Caminha"));
		
		Pergunta p3 = new Pergunta(3, "Quem foi Pero Vaz de Caminha", "João");
		p3.getRespostas().add(new Resposta(1, "Autor de novela"));

		perguntas.add(p1);
		perguntas.add(p2);
		perguntas.add(p3);		
		
	}
}
