package io.server.ws.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

/**
 * Collect all the app models.
 * 
 * @author s7n
 */
@Getter
@Setter
@XmlRootElement
public class AppContainer {

	@XmlElement(name = "apps")
	private List<App> apps;

	@SuppressWarnings("unused")
	private AppContainer() {
		// hidden constructor for jaxb
	}

	public AppContainer(final App... apps) {
		if (apps != null) {
			this.apps = new ArrayList<>(Arrays.asList(apps)); // modifiable list
		} else {
			this.apps = new ArrayList<>();
		}
	}
}
