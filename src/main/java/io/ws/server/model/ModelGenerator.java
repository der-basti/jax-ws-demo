package io.ws.server.model;

import java.io.File;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * Demo generator.
 * 
 * @author s7n
 */
public class ModelGenerator {

	public static final String RESOURCE_LOCATION = "src/main/resources/";
	public static final String RESOURCE_FILE = "data.xml";

	public static void main(String[] args) {
		final boolean activated = true;
		
		// FIXME
		final byte[] appdata = "appdata".getBytes();
		
		App tutti = new App(1L, "Tutti Emulator", "Best Terminal Emulator",
				0.01, activated, new Date(), "checksum", appdata.toString());
		App runaway = new App(2L, "StressWa", "Sport Tracking App", 0.99,
				activated, new Date(), "checksum", appdata.toString());
		App chrofox = new App(3L, "ChroFox", "Ultimate Web Browser", 0.49,
				activated, new Date(), "checksum", appdata.toString());
		App go = new App(4L, "Go!", "The Game", 0.25, activated, new Date(),
				"checksum", appdata.toString());
		marshal(new File(RESOURCE_LOCATION + RESOURCE_FILE), new AppContainer(
				tutti, runaway, chrofox, go));
	}

	public static void marshal(final File file, final AppContainer ac) {
		try {
			JAXBContext jaxbContext = JAXBContext
					.newInstance(AppContainer.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			// pretty output
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(ac, file);
		} catch (final JAXBException e) {
			e.printStackTrace();
		}
	}

	public static AppContainer unmarshal(final File file) {
		try {
			JAXBContext jaxbContext = JAXBContext
					.newInstance(AppContainer.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			return (AppContainer) jaxbUnmarshaller.unmarshal(file);
		} catch (final JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}
}
