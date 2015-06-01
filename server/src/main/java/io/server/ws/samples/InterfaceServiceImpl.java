package io.server.ws.samples;

import javax.jws.WebService;

@WebService(name = "InterfaceService", targetNamespace = "http://samples.ws.server.io/InterfaceService", serviceName = "InterfaceService", endpointInterface = "io.server.ws.samples.InterfaceService")
public class InterfaceServiceImpl implements InterfaceService {

	@Override
	public String sayHello(String name) {
		return "Hello " + name;
	}

}
