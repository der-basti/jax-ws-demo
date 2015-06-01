package io.server.ws.samples;

import javax.jws.WebService;

/**
 * Fault handling samples.
 * 
 * @author s7n
 * 
 */
@WebService
public class FaultService {

	// default
	public void e1() throws Exception {
		throw new Exception("e1 exception message.");
	}

	// custom
	public void e2() throws FaultMy {
		throw new FaultMy("e2 exception message.", new FaultException());
	}
}
