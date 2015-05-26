package io.server.ws;

import javax.jws.WebService;

/**
 * The simplest JAX-WS (http://localhost:8080/jax-ws-demo/EchoSimpleService?wsdl).
 * 
 * @author s7n
 */
@WebService
public class EchoSimpleService {

	public String getHello() {
		return "Hello World";
	}

	protected void notVisible() {
		// nothing to do
	}
}
