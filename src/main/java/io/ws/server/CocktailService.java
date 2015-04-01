package io.ws.server;

import io.model.Cocktail;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Basic cocktail SOAP.
 * 
 * @author s7n
 */
@WebService
public class CocktailService {

	public List<Cocktail> getAll() {
		return null;
	}

	public Cocktail get(final @WebParam(name = "id") Long id) {
		return null;
	}
}
