package br.com.fiap.aspecto;

import org.apache.log4j.Logger;

public aspect AuditoriaAspecto {

	private int _callDepth = -1;

	pointcut tracePoints() :  within(br.com.fiap.dao.* );

	after() : tracePoints(){  
		print("After", thisJoinPoint);
		_callDepth++; 
	}

	before() : tracePoints() {
		_callDepth++;
		print("Before", thisJoinPoint);
	}

	private void print(String prefix, Object messagem) {

		for (int i = 0, spaces = _callDepth * 2; i < spaces; i++) {
			Logger log = Log.getInstance();
//			log.info(messagem);
//			System.out.print(" ");
		}

		//		System.out.println(prefix + ": " + messagem);
	}
}
