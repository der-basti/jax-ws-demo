package io.server.ws.samples;

import javax.jws.WebService;

// wsdlLocation="WEB-INF/wsdl/InterfaceService.wsdl"
@WebService(name = "InterfaceService", serviceName = "InterfaceService", endpointInterface = "io.server.ws.samples.InterfaceService", targetNamespace = "http://samples.ws.server.io/InterfaceService")
public class InterfaceServiceImpl implements InterfaceService {

	@Override
	public String sayHello(final String name) {
		return "Hello " + name;
	}

}
