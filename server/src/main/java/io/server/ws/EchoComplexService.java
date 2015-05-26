package io.server.ws;


//@WebService(endpointInterface = "", name = "", portName = "", serviceName = "", targetNamespace = "", wsdlLocation = "")
//@SOAPBinding(parameterStyle = ParameterStyle.WRAPPED, style = Style.DOCUMENT, use = Use.LITERAL)
public class EchoComplexService {

	// @WebMethod(action = "getHello", exclude = true, operationName = "getHello")
	public String getHello() {
		return "Hello World";
	}

	protected void notVisible() {
		// nothing to do
	}
}