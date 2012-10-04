package br.com.fiap.aspecto;

import org.apache.log4j.Logger;

public aspect TratamentoExecption {
	// Instancia do log
	 Logger log = Log.getInstance();
	
	//Tratamento do log
	before():handler(Exception || RuntimeException) {
		
		log.warn("Exeption"+thisJoinPoint.getArgs()[0]); 
		
	}
	
	
	
	
		 
	 
	 
	 

}
