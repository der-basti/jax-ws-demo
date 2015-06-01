package io.server.ws.samples;

import javax.jws.WebService;

/**
 * http://localhost:8080/jax-ws-demo-server/EchoSimpleService?wsdl
 * 
 * @author s7n
 * 
 */
@WebService
public class EchoSimpleService {

	public String sayHello(final String name) {
		return "Hello " + name;
	}
}
