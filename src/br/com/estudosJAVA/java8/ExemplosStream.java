/**
 * 
 */
package br.com.estudosJAVA.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

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

		/**
		 * Principais conceitos introduzidos no java 8
		 * 
		 * Method Reference
		 * Lambda - Linguagem funcional
		 * Default method - Interface pode ter m�todo defaul, que j� possui a implementa��o (m�todo concreto) e n�o quebra as classes que j� utilizam esta interface
		 * Conceito de Interface Funcional - Interface que cont�m apenas um m�todo abstrato (N�o s�o m�todos default, que s�o m�todos concretos)
		 */
		//exemplosComparatorComLambda();	

		// Stream: O conceito � tipo, me devolva todos os tipos de m�todos poss�veis que eu vejo os que vou usar.
		// O stream vai fazer uma c�pia da collection e vai utilizar a c�pia. Ou seja, ela n�o muda a ordem da collection original.
		// Caso voc� queira a collection resultante, utiliza-se o Collector.collect no final.
		exemplosComStream();

	}
	
	private static void exemplosComStream(){
		System.out.println("---------- exemplosComStream ------------");
		
		// Utiliza o predicado, e tamb�m � uma classe anonima, logo tb podemos usar o lambda
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
		
		System.out.println("-------------- NOVOS EXEMPLOS");
//		perguntas.forEach(System.out::println);
		perguntas.stream()
		.filter(p -> p.getRespostas().size() >= 2)
		.filter(p -> !p.getAutor().isEmpty())
		//.map(p -> p.getRespostas().size())
		.mapToInt(p -> p.getRespostas().size())
		//.map(p -> p.getPergunta())
		.forEach(System.out::println);
		
		// Imprimir a somar a quantidade de perguntas que tiveram mais que 1 resposta e que o autor n�o esteja vazia
		long totalPerguntas =  perguntas.stream()
		.filter(p -> p.getRespostas().size() > 1)
		.filter(p -> !p.getAutor().isEmpty())
		.map(p -> p.getPergunta())
		.count();
		
		System.out.println("Total Perguntas com mais de 1 resposta e autor conhecido: " + totalPerguntas );
		
		
		System.out.println("-Retornar todas as perguntas que tiveram mais que 1 resposta e que o autor n�o esteja vazia");
		// Retornar todas as perguntas que tiveram mais que 1 resposta e que o autor n�o esteja vazia
		List<Pergunta> listaPerguntas =  perguntas.stream()
		.filter(p -> p.getRespostas().size() > 1)
		.filter(p -> !p.getAutor().isEmpty())
		//.map(p -> p)
		.collect(Collectors.toList());
		
		listaPerguntas.forEach(System.out::println);
		
		
		// Agrupar perguntas pelo nome do Autor
		System.out.println("- Agrupar perguntas pelo nome do Autor");
		// Retornar todas as perguntas que tiveram mais que 1 resposta e que o autor n�o esteja vazia
		Map<String, List<Pergunta>> mapPerguntas =  perguntas.stream()
		.filter(p -> p.getRespostas().size() > 1)
		.filter(p -> !p.getAutor().isEmpty())
		.collect(Collectors.groupingBy(Pergunta:: getAutor));
		
		mapPerguntas.forEach((key, value) -> {
		    System.out.println("Autor : " + key + " Pergunta : " + value);
		});		
	}
	
	private static <T> void exemplosComparatorComLambda(){
		System.out.println("---------- exemplosComparatorComLambda ------------");
		
		// Novo foreach
		perguntas.forEach(new Consumer<Pergunta>() {
			@Override
			public void accept(Pergunta t) {
				System.out.println(t.getPergunta());
			}
		});
		
		// utilizando lambda. Ex1 - Utilizando mais de um comando no m�todo implementado
		perguntas.forEach(
			(Pergunta t) -> {
				System.out.println(t.getPergunta());
				System.out.println(t.getAutor());
		});
		
		// utilizando lambda. Ex2
		perguntas.forEach((Pergunta t) -> System.out.println(t.getPergunta()));
		
		// utilizando lambda. Ex3
		perguntas.forEach((p) -> System.out.println(p.getPergunta()));
		
		// utilizando lambda. Ex4
		// Vai imprimir o toString() do objeto
		perguntas.forEach(System.out::println);
		
		
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
		
		perguntas.forEach(System.out::println);
		
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
		
		// Como o Comparator tamb�m � uma interface funcional, podemos utilizar o lambda
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
		// A classe Integer j� faz a compara��o entre inteiros. Ent�o podemos simplificar ainda mais... Basicamente ele j� faz os ifs de compara��o.
		perguntas.sort( (p1, p2) -> {
				return Integer.compare(p1.getRespostas().size(), p2.getRespostas().size());
			}
		);
		
		// Ex 4
		// Simplificando...
		perguntas.sort( (p1, p2) -> Integer.compare(p1.getRespostas().size(), p2.getRespostas().size()));		

		// Ex 5
		// Utilizando agora o novo m�todo comparing do Comparator
		// Passamos o objeto e o crit�rio de compara��o que ele se vira
		perguntas.sort(Comparator.comparing(p -> p.getRespostas().size()));
		
		// Comparando pelo autor
		perguntas.sort(Comparator.comparing(p -> ((Pergunta) p).getAutor()).reversed());
		
		
		// Method reference
		// Sem method reference
		perguntas.sort(Comparator.comparing(p -> p.getAutor()));
		// Com method reference
		// Dado o objeto pergunta, chame o m�todo getAutor dela
		perguntas.sort(Comparator.comparing(Pergunta::getAutor));
		
		perguntas.forEach(p -> System.out.println(p.toString()));
		
		// Ex 6
		// Mudando o criterio de compara��o...
		perguntas.sort(Comparator.comparing(p -> p.getId()));		
		
		perguntas.forEach(p -> System.out.println(p.toString()));	
		
		
		perguntas.forEach(p -> {
				System.out.println(p.getPergunta());
				p.getRespostas().forEach(r -> System.out.println("Resposta: "+  r.getConteudo()));
			});
				
		
		
	}

	private static void criarPerguntas(){
		System.out.println("---------- criarPerguntas ------------");
		
		perguntas = new ArrayList<Pergunta>();

		Pergunta p1 = new Pergunta(1, "Quais as cores da bandeira do Brasil?", "Marcelo");
		
		p1.getRespostas().add(new Resposta(1, "Estou em d�vida"));
		p1.getRespostas().add(new Resposta(2, "Azul, verde e amarela"));
		p1.getRespostas().add(new Resposta(3, "Azul, verde e amarela e branca"));
		
		Pergunta p2 = new Pergunta(2, "Quem descobriu o Brasil?", "Pedro");
		
		p2.getRespostas().add(new Resposta(1, "Jo�o Neto e Frederico"));
		p2.getRespostas().add(new Resposta(2, "Pero Vaz de Caminha"));
		
		Pergunta p3 = new Pergunta(3, "Quem foi Pero Vaz de Caminha?", "Jo�o");
		p3.getRespostas().add(new Resposta(1, "Autor de novela"));
		
		
		Pergunta p4 = new Pergunta(4, "Quantos Estados tem o Brasil?", "Marcelo");
		p4.getRespostas().add(new Resposta(1, "23 Estados"));
		p4.getRespostas().add(new Resposta(2, "24 Estados"));
		p4.getRespostas().add(new Resposta(3, "25 Estados"));
		p4.getRespostas().add(new Resposta(4, "26 Estados"));
		p4.getRespostas().add(new Resposta(5, "27 Estados"));

//		perguntas.add(p1);
//		perguntas.add(p2);
//		perguntas.add(p3);
		
		perguntas.addAll(Arrays.asList(p1, p2, p3, p4));
		
	}
}
