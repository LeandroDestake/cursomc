package com.nelioalves.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.repositories.CategoriaRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner  {

	//vamos criar uma dependencia para o repository
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática"); //null é que o codigo gera automatico no banco
		Categoria cat2 = new Categoria(null, "Escritório");
		
		//Agora vamos salvar no banco de dados, só que vamos direto no
		//repository, nesse save ele aceita apenas um registro ou uma lista
		//no nosso caso é uma lista que vamos salvar
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		
		
	}

}
