package io.server.ws;

import io.server.ws.model.App;
import io.server.ws.model.AppContainer;
import io.server.ws.model.ModelGenerator;
import io.server.ws.model.ReturnCode;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;

/**
 * The one and only backend bean.
 * 
 * @author s7n
 */
@Stateful
@LocalBean
public class BackendBean implements Serializable {

	private static final long serialVersionUID = -3921199152183955121L;

	private AppContainer appContainer;

	/**
	 * Re-/load the sample/demo application container.
	 */
	@PostConstruct
	public void init() {
		this.appContainer = ModelGenerator.getModel();
	}

	/**
	 * Find all available applications.
	 * 
	 * @return {@link AppService} list
	 */
	public List<App> findAll() {
		return this.appContainer.getApps().stream()
				.filter(e -> e.isActivated())
				.collect(Collectors.<App> toList());
	}

	/**
	 * Find a application by name.
	 * 
	 * @param name
	 *            string
	 * @return {@link AppService} list
	 */
	public List<App> find(final String name) {
		return this.appContainer.getApps().stream()
				.filter(e -> e.getName().equalsIgnoreCase(name))
				.collect(Collectors.<App> toList());
	}

	/**
	 * Get application by id.
	 * 
	 * @param id
	 *            Long
	 * @return {@link AppService} or null
	 */
	public App get(final Long id) {
		return this.appContainer.getApps().stream().findFirst()
				.filter(e -> e.getId() == id).orElse(null);
	}

	/**
	 * Get application data by id.
	 * 
	 * @param id
	 * @return byte[] or null;
	 */
	// TODO @MTOM
	public byte[] getBinary(Long id) {
		App app = get(id);
		if (app == null) {
			return null;
		}
		// TODO open url and send binary
		return app.getAppUrl().getBytes();
	}

	/**
	 * Update a existing app by id.
	 * 
	 * @param id
	 *            Long
	 * @param name
	 *            application name
	 * @param description
	 *            application description
	 * @param price
	 *            application price
	 * @param data
	 *            application data
	 * @return {@link ReturnCode}
	 */
	public ReturnCode update(final Long id, final String name,
			final String description, final Double price, final byte[] data) {
		for (final Iterator<App> ia = this.appContainer.getApps().iterator(); ia
				.hasNext();) {
			App app = ia.next();
			if (app.getId() == id) {
				app.setActivated(true);
				app.setDescription(description);
				app.setName(name);
				app.setPrice(price);
				// TODO update app
				// app.setAppUrl(appUrl);
				// app.setChecksum(checksum);
				return ReturnCode.SUCCESS;
			}
		}
		return ReturnCode.OBJECT_NOT_FOUND;
	}

	/**
	 * Delete application by id.
	 * 
	 * @param id
	 * @return
	 */
	public ReturnCode delete(final Long id) {
		App app = this.appContainer.getApps().stream()
				.filter(e -> e.getId().equals(id)).findFirst().orElse(null);
		if (app == null) {
			return ReturnCode.OBJECT_NOT_FOUND;
		}
		app.setActivated(false);
		return ReturnCode.SUCCESS;
	}
}
