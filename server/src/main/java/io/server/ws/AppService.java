package io.server.ws;

import io.server.ws.model.App;
import io.server.ws.model.ReturnCode;

import java.awt.Image;
import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.soap.MTOM;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Basic app web service.
 * 
 * @author s7n
 */
@Stateless
@WebService
@MTOM
// (threshold = 1000000) // binary data // extend | inline base64
public class AppService {

	private Logger log = LoggerFactory.getLogger(AppService.class);

	@Inject
	private BackendBean backendBean;

	/**
	 * List of all activated applications.
	 * 
	 * @return List of {@link AppService}
	 */
	public List<App> listAll() {
		log("listAll");
		return this.backendBean.findAll();
	}

	/**
	 * List of all inactivated applications.
	 * 
	 * @return {@link App} list
	 */
	public List<App> listAllInactivated() {
		log("find inactivated apps");
		return this.backendBean.findAllInactivated();
	}

	/**
	 * Find a specific app by id.
	 * 
	 * @param id
	 *            long
	 * @return AppService object id exists, else 'nothing'.
	 */
	public App getAppById(final @WebParam(name = "id") long id) {
		log("getAppById", id);
		final App app = this.backendBean.get(id);
		if (app != null) {
			return app;
		}
		return null;
	}

	/**
	 * Find a application by name.
	 * 
	 * @param name
	 *            string
	 * @return {@link App} list
	 */
	public List<App> find(final @WebParam(name = "name") String name) {
		log("find", name);
		return this.backendBean.find(name);
	}

	/**
	 * Get application image (MTOM).
	 * 
	 * @param id
	 *            long
	 * @return byte[] image data
	 */
	public Image downloadImage(final @WebParam(name = "id") long id) {
		log("downloadImage", id);
		return this.backendBean.getImage(id);
	}

	/**
	 * 
	 * @param image
	 * @return
	 */
	public ReturnCode uploadImage(final @WebParam(name = "id") long id,
			final @WebParam(name = "image") Image image) {
		log("uploadImage", id);
		if (image == null) {
			return ReturnCode.OBJECT_NOT_FOUND;
		}
		this.backendBean.updateImage(id, image);
		return ReturnCode.SUCCESS;
	}

	/**
	 * Update a specific application.
	 * 
	 * @param app
	 *            identify by id and include all informations.
	 * @return {@link ReturnCode}
	 * @throws Exception
	 */
	public ReturnCode update(final @WebParam(name = "id") long id,
			final @WebParam(name = "activated") Boolean activated,
			final @WebParam(name = "name") String name,
			final @WebParam(name = "description") String description,
			final @WebParam(name = "price") Double price) throws Exception {
		log("update", id);
		// just a simple backend call
		return this.backendBean.update(id, activated, name, description, price);
	}

	/**
	 * Delete a specific application.
	 * 
	 * @param id
	 *            application identifier
	 * @return {@link ReturnCode}
	 */
	public ReturnCode delete(final @WebParam(name = "id") long id) {
		log("delete app", id);
		return this.backendBean.delete(id);
	}

	private void log(final String message, final Object... parameter) {
		this.log.info(message + " : " + Arrays.toString(parameter));
	}
}
