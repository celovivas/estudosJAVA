/**
 * 
 */
package br.com.estudosJAVA.java8.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marcelo
 *
 */
public class Pergunta {
	
	public Pergunta(){
	}
	
	public Pergunta(Integer id, String pergunta, String autor){
		this.id = id;
		this.pergunta = pergunta;
		this.autor = autor;
		respostas = new ArrayList<Resposta>();
	}
	
	private Integer id;
	private String pergunta;
	private String autor;
	private List<Resposta> respostas;
	
	
	
	@Override
	public String toString() {
		return id + "; " + pergunta + "; " + autor  + "; Total Respostas: " + respostas.size();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public List<Resposta> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}

}
