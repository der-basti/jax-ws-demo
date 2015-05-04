package io.ws.server;

import io.ws.server.model.App;
import io.ws.server.model.ReturnCode;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebService;
import javax.validation.constraints.NotNull;

/**
 * Basic app web service.
 * 
 * @author s7n
 */
@WebService
public class AppService {

	@Inject
	private BackendBean backendBean;

	/**
	 * App include App (name, id, description) informations.
	 * 
	 * @return List of {@link App}
	 */
	public List<App> listAll() {
		return this.backendBean.findAll();
	}

	/**
	 * Find a specific app by id.
	 * 
	 * @param id
	 *            long
	 * @return App object id exists, else FIXME .
	 */
	public App getAppById(final Long id) {
		App app = this.backendBean.get(id);
		if (app != null)
			return app;

		// FIXME SOAP FAULT
		return null;
	}

	/**
	 * Sample for MTOM.
	 * 
	 * @param id
	 *            long
	 * @return byte[] application data
	 */
	public byte[] getBinary(final Long id) {
		return this.backendBean.getBinary(id);
	}

	/**
	 * Update a specific application.
	 * 
	 * @param app
	 *            identify by id and include all informations.
	 * @param data
	 *            optional byte[].
	 * @return {@link ReturnCode}
	 */
	public ReturnCode update(final @NotNull App app, final byte[] data) {
		// validierung not changed (id, addDate, checksum)
		return this.backendBean.update(app.getId(), app.getName(),
				app.getDescription(), app.getPrice(), data);
	}

	/**
	 * Delete a specific application.
	 * 
	 * @param id
	 *            application identifier
	 * @return {@link ReturnCode}
	 */
	public ReturnCode delete(final Long id) {
		return this.backendBean.delete(id);
	}
}
