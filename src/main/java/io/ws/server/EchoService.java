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
<<<<<<< HEAD
		return "Hello World";
=======
		return getHello("World");
	}

	public String getHello(final String name) {
		return "Hello " + name;
>>>>>>> 255ef0f085ce6fa883217fd99677bafe1bf16ed8
	}
	
	protected void notVisible() {
		// nothing to do
	}
}
