package io;

import io.model.App;
import io.model.AppContainer;

import java.io.File;

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

	public static final String resourceLocation = "src/main/resources/";

	public static void main(String[] args) {
		App tutti = new App();
		App runaway = new App();
		App chrofox = new App();
		marshal(new File(resourceLocation + "data.xml"), new AppContainer(tutti, runaway, chrofox));
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
