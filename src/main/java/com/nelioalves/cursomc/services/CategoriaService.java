package com.nelioalves.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	//Vamos ter que declarar uma dependencia de um objto do tipo Categoria Repository
	//pois ele vai entrar em contato  com a classe CategoriaRepository no pacote 
	//com.repositories
	
	//Quando declaramos uma dependencia dentro de uma classe e usa a anotação @Autowired
	//a dependencia "repo" vai ser instanciada automaticamente pelo spring
	@Autowired
	private CategoriaRepository repo; //Aqui ele vai acessar a camada de acessoa a dados repository
		
	
	//Uma operação para buscar uma categoria por codigo Categoria
	//é o tipo de dado que esta operação vai retornar, isso é uma assinatura de método
	//Aqui recebemos 
	public Categoria buscar(Integer id) {
		//precisamos implementar um serviço que busca categoria
		//essa operação vai no banco de dados		 
		//busca uma categoria com esse ID
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);		
	}

}
