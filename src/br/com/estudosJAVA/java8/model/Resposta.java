/**
 * 
 */
package br.com.estudosJAVA.java8.model;

/**
 * @author Marcelo
 *
 */
public class Resposta {
	
	public Resposta(Integer id, String conteudo){
		this.id = id;
		this.conteudo = conteudo;
	}

	private Integer id;
	private String conteudo;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	
}
