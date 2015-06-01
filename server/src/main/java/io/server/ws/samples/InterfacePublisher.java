package io.server.ws.samples;

import javax.xml.ws.Endpoint;

public class InterfacePublisher {

	/**
	 * Create a Web Service Endpoint (Java SE).
	 * 
	 * wsgen -keep -cp . io.server.ws.samples.InterfaceService
	 * 
	 * generate GetHelloWorldAsString and GetHelloWorldAsStringResponse
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8181/ws/echoComplex",
				new EchoComplexService());
	}
}
