package com.nelioalves.cursomc.services.exceptions;

//extendemos da classe runtimeexception
public class ObjectNotFoundException extends RuntimeException{

	//Colocamos o numero de versão 1
	private static final long serialVersionUID = 1L;
	
	//vamos criar o construtor agora recebendo uma string
	public ObjectNotFoundException(String msg) {
		//vamos chamar a super classe que é RuntimeException
		//vamos repassar essa mensagem para ela mesma RuntimeException
		super(msg);
		
	} 
	
	//vamos fazer outro construtor que seria para receber alguma esseção
	//de alguma causa que aconteceu antes
	public ObjectNotFoundException(String msg, Throwable cause) {
		//Então tb repassamos esse tipo de construtor para a super classe
		super(msg, cause);
	}

}
