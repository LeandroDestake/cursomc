package com.nelioalves.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Double preco;
	
	//Agora precisamos fazer o relacionamento de muitos para muitos
	//entre Produto e categoria muitos p/ muitos vou ter que ter uma
	//terceira tabela, no JPA quando tem esse tipo de relação precisamos colocar
	//a anotação ManyToMany, isso pq vamos ter uma lista de cada lado
	
	    @ManyToMany	   
	    @JoinTable(name = "PRODUTO_CATEGORIA", //"PRODUTO_CATEGORIA É o nome da terceira tabela" //É nessa cara que vamos definir qual vai ser  a tabela que vai fazer o muitos para muitos no banco relacional
	    	joinColumns = @JoinColumn(name = "produto_id"), //"produto_id" é a chave estrangeira da classe\tabela que estou no caso produto joinColumns é uma declaração, ai atribuimos a anotação @JoinColumn
	    	inverseJoinColumns = @JoinColumn(name = "categoria_id") //Agora precisamos colocar aqui qual é o nome da outra chave estrangeira que vai referenciar a categoria o nome vai ser categoria_id
	                         
	    		)//Feito isso tb vamos precisar fazer isso na classe categoria
	private List<Categoria> categorias = new ArrayList<>();
	
	public Produto() {
		
		
	}
	
	

	//Categoria é coleção não entra no construtor até pq ela ja
	//foi iniciada no código acima
	public Produto(Integer id, String nome, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	//Necessario para fazermos comparações apenas com o conteudo não com o ponteiro
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
