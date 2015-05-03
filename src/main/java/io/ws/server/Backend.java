package io.ws.server;

import static io.ws.server.model.ModelGenerator.RESOURCE_FILE;
import static io.ws.server.model.ModelGenerator.RESOURCE_LOCATION;
import io.ws.server.model.App;
import io.ws.server.model.AppContainer;
import io.ws.server.model.ModelGenerator;
import io.ws.server.model.ReturnCode;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;

/**
 * The one and only backend bean.
 * 
 * @author s7n
 */
@Stateful
@LocalBean
public class Backend implements Serializable {

	private static final long serialVersionUID = -3921199152183955121L;

	private AppContainer appContainer;

	public Backend() {
		init(RESOURCE_LOCATION + RESOURCE_FILE);
	}

	public void init(final String source) {
		this.appContainer = ModelGenerator.unmarshal(new File(source));
	}

	protected List<App> findAll() {
		return this.appContainer.getApps();
	}

	protected List<App> find(final String name) {
		return this.appContainer.getApps().stream()
				.filter(e -> e.getName().equalsIgnoreCase(name))
				.collect(Collectors.<App> toList());
	}

	protected App get(final Long id) {
		return this.appContainer.getApps().stream().findFirst()
				.filter(e -> e.getId() == id).get();
	}

	public byte[] getBinary(Long id) {
		// FIXME open url and send ...
		get(id).getAppUrl();
		return null;
	}

	public ReturnCode update(String name, String description, Double price,
			byte[] data) {
		// TODO Auto-generated method stub
		return ReturnCode.SUCCESS;
	}

	public ReturnCode delete(final Long id) {
		final App app = get(id);
		if (app != null) {
			app.setActivated(false);
			return ReturnCode.SUCCESS;
		}
		return ReturnCode.OBJECT_NOT_FOUND;
	}
}
