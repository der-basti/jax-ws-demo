package io.server.ws.samples;

import javax.jws.WebService;

/**
 * The simplest JAX-WS (http://localhost:8080/jax-ws-demo-server/EchoSimpleService?wsdl).
 * 
 * @author s7n
 */
@WebService
public class EchoSimpleService {

	public String getHello() {
		return "Hello World";
	}
}
