package io.ws.server;

import javax.jws.WebService;

/**
 * The simples JAX-WS (http://localhost:8080/jax-ws-demo/EchoService?wsdl).
 * 
 * @author s7n
 */

@WebService
public class EchoService {

	public String getHello() {
		return getHello("World");
	}

	public String getHello(final String name) {
		return "Hello " + name;
	}
	
	protected void notVisible() {
		// nothing to do
	}
}
