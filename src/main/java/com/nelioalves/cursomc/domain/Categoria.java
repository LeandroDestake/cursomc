package com.nelioalves.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //Isso faz gerar o Id automatico o IDENTITY da certo com Varios Bancos.
	private Integer id;                               //dependendo do banco vamos ter que escolher outro tipo de geração de
	private String nome;                              //chave primaria
	
	@JsonManagedReference//Com isso avisamos que esta tudo bem em seriallizar os produtos isso é uma referencia gerenciada pelo json isso é uma anotação do pacote jackson import, agente faz isso do lado que queremos que venha os objetos associados
	//Esse nome produtos é o papel que esta no diagrama do banco
	@ManyToMany(mappedBy="categorias") //Não pe necessário fazer todo aquele mapeamento =  a classe Produto.java
	private List<Produto> produtos = new ArrayList<>();
	
	public Categoria() {
		
	}

	public Categoria(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
	
	

}
