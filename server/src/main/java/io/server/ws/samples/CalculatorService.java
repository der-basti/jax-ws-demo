package io.server.ws.samples;

import java.io.Serializable;
import java.util.Arrays;

import javax.jws.HandlerChain;
import javax.jws.Oneway;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Basic Calculator Service.
 * 
 * @author s7n
 *
 */
@WebService
@HandlerChain(file = "/handlers.xml")
public class CalculatorService implements Serializable {

	private static final long serialVersionUID = -1693349157716282888L;

	private Logger log = LoggerFactory.getLogger(CalculatorService.class);

	/**
	 * a add b.
	 * 
	 * @param a
	 *            int
	 * @param b
	 *            int
	 * @return result
	 */
	public int plus(final @WebParam(name = "a") int a,
			final @WebParam(name = "b") int b) {
		return a + b;
	}

	/**
	 * a minus b.
	 * 
	 * @param a
	 *            int
	 * @param b
	 *            int
	 * @return result
	 * @throws IllegalArgumentException
	 *             if a bigger than 100.
	 */
	public int minus(final @WebParam(name = "a") int a,
			final @WebParam(name = "b") int b) throws IllegalArgumentException {
		if (a > 100) {
			throw new IllegalArgumentException(
					"Maximum value of parameter a is 100.");
		}
		return a - b;
	}

	/**
	 * MEP in-only.
	 */
	@Oneway
	public void oneWay(final String arg) {
		log("one way only : " + arg);
	}

	/**
	 * MEP in-only rubust.
	 */
	@Oneway
	public void oneWayRobust(final String arg) throws Exception {
		oneWay(arg);
		if (arg == null || arg.length() <= 2) {
			throw new Exception("Length of parameter arg is less 2.");
		}
	}

	private void log(final String message, final Object... parameter) {
		this.log.info(message + " : " + Arrays.toString(parameter));
	}
}
