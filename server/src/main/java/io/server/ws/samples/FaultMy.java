package io.server.ws.samples;

import javax.xml.ws.WebFault;

import lombok.Getter;

@Getter
@WebFault(name = "FaultException", targetNamespace = "http://samples.ws.server.io/")
public class FaultMy extends Exception {

	private static final long serialVersionUID = 2668306520002387213L;

	// fault detail element
	private FaultException faultInfo;

	public FaultMy(final String message, final FaultException faultInfo) {
		super(message);
		this.faultInfo = faultInfo;
	}

	public FaultMy(final String message, final FaultException faultInfo,
			final Throwable cause) {
		super(message, cause);
		this.faultInfo = faultInfo;
	}
}