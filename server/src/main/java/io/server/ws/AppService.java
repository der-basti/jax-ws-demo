package io.server.ws;

import io.server.ws.model.App;
import io.server.ws.model.ReturnCode;

import java.awt.Image;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.jws.WebService;
import javax.validation.constraints.NotNull;
import javax.xml.ws.soap.MTOM;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Basic app web service.
 * 
 * @author s7n
 */
@WebService
@MTOM
public class AppService {

	private Logger log = LoggerFactory.getLogger(AppService.class);

	@Inject
	private BackendBean backendBean;

	/**
	 * AppService include AppService (name, id, description) informations.
	 * 
	 * @return List of {@link AppService}
	 */
	public List<App> listAll() {
		log("listAll");
		return this.backendBean.findAll();
	}

	/**
	 * Find a specific app by id.
	 * 
	 * @param id
	 *            long
	 * @return AppService object id exists, else FIXME
	 */
	public App getAppById(final Long id) {
		log("getAppById", id);
		final App app = this.backendBean.get(id);
		if (app != null) {
			return app;
		}
		// FIXME SOAP FAULT
		return null;
	}

	/**
	 * Get application image (MTOM).
	 * 
	 * @param id
	 *            long
	 * @return byte[] image data
	 */
	public Image downloadImage(final Long id) {
		log("downloadImage", id);
		return this.backendBean.getImage(id);
	}

	/**
	 * 
	 * @param image
	 * @return
	 */
	public ReturnCode uploadImage(final Long id, final Image image) {
		log("uploadImage", id);
		if (image == null) {
			return ReturnCode.OBJECT_NOT_FOUND;
		}
		// do magic
		return ReturnCode.SUCCESS;
	}

	/**
	 * Update a specific application.
	 * 
	 * @param app
	 *            identify by id and include all informations.
	 * @return {@link ReturnCode}
	 */
	@Deprecated
	public ReturnCode update(final @NotNull App app) {
		log("update", app.getId());
		// validierung not changed (id, addDate, checksum, image)
		return this.backendBean.update(app.getId(), app.getName(),
				app.getDescription(), app.getPrice());
	}

	/**
	 * Delete a specific application.
	 * 
	 * @param id
	 *            application identifier
	 * @return {@link ReturnCode}
	 */
	public ReturnCode delete(final Long id) {
		log("delete app", id);
		return this.backendBean.delete(id);
	}

	private void log(final String message, final Object... parameter) {
		this.log.info(message + " : " + Arrays.toString(parameter));
	}
}
