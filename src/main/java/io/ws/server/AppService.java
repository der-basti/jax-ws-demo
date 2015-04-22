package io.ws.server;

import io.model.App;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.MTOM;

/**
 * Basic app web service.
 * 
 * @author s7n
 */
@WebService
//@MTOM
//@BindingType(value=javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_MTOM_BINDING)
public class AppService {

	public List<App> getAll() {
		return null;
	}
	
	public void find(final String name) {
		
	}

	public App getAppInfo(final Long id) {
		return new App();
	}
	public void getApp(final Long id) {
		//
	}
}
