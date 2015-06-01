package io.server.ws.samples;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace = "io.server.ws.samples.InterfaceService")
public interface InterfaceService {

	@WebResult(name = "sayHelloMessage")
	@WebMethod(operationName = "sayHello")
	public String sayHello(@WebParam(name = "name") String name);
}
