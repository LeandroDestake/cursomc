package com.nelioalves.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.services.CategoriaService;

@RestController  
@RequestMapping(value="/categorias") //nesse endpoint ele vai receber o ID da categoria
public class CategoriaResource {
	
	@Autowired //ja instancia o objeto
	private CategoriaService service;
	
	//ResponseEntity ele é um tipo especial do spring boot pq ele encapsula ele armazena de uma resposta http
	//para um serviço REST
	@RequestMapping(value="/{id}", method=RequestMethod.GET) //{id} é apelido pode ser qq nome esse id é da url
	public ResponseEntity<?> find(@PathVariable Integer id) { // O endpointo desse cara agora é /categoria e /id e esse id da variavel
		                //? PQ PODE ENCONTRAR QQ TIPO        //Para saber que vem da URL precisa usar anotação @PathVariable
		
		//aqui estamos acessando oa camada de serviços
		Categoria obj = service.buscar(id);
		
		return ResponseEntity.ok().body(obj);//vamos retornar um objeto ResponseEntity que contem protocolos variados como http etc...
		         //a reesposta vai ter como ok no corpo o obj buscado que é a categoria
		
	}

}
