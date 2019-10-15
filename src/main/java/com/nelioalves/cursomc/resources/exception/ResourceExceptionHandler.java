package com.nelioalves.cursomc.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nelioalves.cursomc.services.exceptions.ObjectNotFoundException;

//Esse é o nosso manipulador de exceção
//Para pegarmos o numero do erro e o json pegar o horario todas as informações certinho, vamos criar 
@ControllerAdvice //Isso abaixo é padrão do controlleradvice
public class ResourceExceptionHandler {
	
	//Vamos criar um método éssa é uma classe auxiliar que vai interceptar as excessões
	//e ela dentro desse framework deve ter essa assinatura aqui
	//Esse método objectNotFound vai receber a excessão ObjectNotFoundEception do pacote
	//services.exceptions e tb pega a resposta da requisição em HttpServletRequest
	@ExceptionHandler(ObjectNotFoundException.class)//Precisamos fazer essa anotação recebendo o ObjectNotFoundException.class para indicar que é um tratador de excessão desse tipo de excessão ObjectNotFoundException.class
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		//Então agora vamos estanciar um objeto do tipo standard error
		//e vamos passar os dados no caso de objeto não encontrado
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
                                       
}
