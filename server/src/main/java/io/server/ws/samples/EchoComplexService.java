package io.server.ws.samples;

import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

//@WebService(portName = "EchoComplexServicePort", serviceName = "EchoComplexServiceService", targetNamespace = "http://samples.ws.server.io/", endpointInterface = "io.server.ws.samples.EchoComplexService")
//@SOAPBinding(parameterStyle = ParameterStyle.WRAPPED, style = Style.DOCUMENT, use = Use.LITERAL)
public class EchoComplexService {

	// @WebMethod(action = "getHello", exclude = true, operationName =
	// "getHello")
	// @WebResult()
	public String getHello() {
		return "Hello World";
	}
}
