package io.ws;

import javax.jws.WebService;

/**
 * The simples JAX-WS (http://localhost:8080/jax-ws-demo/SimpleService?wsdl).
 * 
 * @author s7n
 */

@WebService
public class SimpleService {

	public String getSayHello() {
		return getSayHelloTo("World");
	}

	public String getSayHelloTo(final String name) {
		return "Hello " + name;
	}
}
