package io.server.ws.samples;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * http://localhost:8080/jax-ws-demo-server/EchoComplexService?wsdl
 * 
 * @author s7n
 * 
 */
@WebService(name = "EchoComplexService", serviceName = "EchoComplexService", portName = "EchoComplexServicePort", targetNamespace = "http://samples.ws.server.io/")
// serviceName = "EchoComplexServiceService"
// endpointInterface = "io.server.ws.samples.EchoComplexService"
// wsdlLocation="WEB-INF/wsdl/EchoComplexService.wsdl"
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public class EchoComplexService {

	@WebMethod(operationName = "sayHello")
	@RequestWrapper(targetNamespace = "http://samples.ws.server.io/", className = "java.lang.String")
	@ResponseWrapper(targetNamespace = "http://samples.ws.server.io/", className = "java.lang.String")
	@WebResult(name = "return", targetNamespace = "http://samples.ws.server.io/")
	public String sayHello(
			final @WebParam(name = "name", mode = Mode.IN, targetNamespace = "http://samples.ws.server.io/") String name) {
		return "Hello " + name;
	}
}
