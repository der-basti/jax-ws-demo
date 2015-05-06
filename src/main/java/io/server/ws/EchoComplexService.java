package io.server.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService(endpointInterface = "", name = "", portName = "", serviceName = "", targetNamespace = "", wsdlLocation = "")
@SOAPBinding(parameterStyle = ParameterStyle.WRAPPED, style = Style.DOCUMENT, use = Use.LITERAL)
public class EchoComplexService {

	@WebMethod(action = "getHello", exclude = true, operationName = "getHello")
	public String getHello() {
		return "Hello World";
	}

	protected void notVisible() {
		// nothing to do
	}
}
