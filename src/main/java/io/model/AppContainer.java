package io.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;

/**
 * Collect all the app models.
 * 
 * @author s7n
 */
@XmlRootElement
@Getter
public class AppContainer {

	@XmlElement(name = "apps")
	private List<App> apps;

	@SuppressWarnings("unused")
	private AppContainer() {
		// hidden constructor for jaxb
	}

	public AppContainer(final App... apps) {
		if (apps != null) {
			this.apps = Arrays.asList(apps);
		} else {
			this.apps = new ArrayList<>();
		}
	}
}
