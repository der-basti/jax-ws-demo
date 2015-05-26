package io.server.ws.model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.UUID;

import javax.imageio.ImageIO;
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
	public static final String RESOURCE_IMAGE = "th-wildau-logo-500px-breit.png";

	public static void main(String[] args) {
		marshal(new File(RESOURCE_LOCATION + RESOURCE_FILE), getModel());
	}

	public static AppContainer getModel() {
		try {
			final Image img = ImageIO.read(new File("/Users/s7n/Dropbox/"
					+ RESOURCE_IMAGE));
			final boolean activated = true;
			final String appUrl = "/apps/" + UUID.randomUUID() + ".app";
			final String checksum = "foobar"; 
					// FIXME MessageDigest.getInstance("MD5").digest(appUrl.getBytes()).toString();
			App tutti = new App(1L, "Tutti", "Best Terminal Emulator",
					0.01, activated, new Date(), appUrl, checksum, img);
			App runaway = new App(2L, "StressWa", "Sport Tracking AppService",
					0.99, activated, new Date(), appUrl, checksum, img);
			App chrofox = new App(3L, "ChroFox", "Ultimate Web Browser", 0.49,
					activated, new Date(), appUrl, checksum, img);
			App go = new App(4L, "Go!", "The Game", 0.25, activated,
					new Date(), appUrl, checksum, img);
			return new AppContainer(tutti, runaway, chrofox, go);
		} catch (final IOException e) {
			e.printStackTrace();
			return new AppContainer();
		}

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
