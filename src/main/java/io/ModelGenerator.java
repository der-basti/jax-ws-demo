package io;

import io.model.Cocktail;
import io.model.CocktailContainer;
import io.model.Ingredient;
import io.model.Unit;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * Generate a demo cocktails.
 * 
 * @author s7n
 */
public class ModelGenerator {

	private static final String resourceLocation = "src/main/resources/";

	public static void main(String[] args) {
		Cocktail sexOnTheBeach = new Cocktail("Sex on the beach",
				"description", new Ingredient("Kirschsaft", 3f, Unit.CL),
				new Ingredient("Orangensaft", 3f, Unit.CL), new Ingredient(
						"Ananassaft", 3f, Unit.CL), new Ingredient("Wodka", 3f,
						Unit.CL), new Ingredient("Aprikosenlikör", 3f, Unit.CL));
		Cocktail nic = new Cocktail("Nic", "description", new Ingredient("Gin",
				4f, Unit.CL), new Ingredient("Ginger Ale", 10f, Unit.CL),
				new Ingredient("Orangensaft", 3f, Unit.CL));
		Cocktail zombie = new Cocktail("Zombie", "description", new Ingredient(
				"Rum weiß", 4f, Unit.CL), new Ingredient("Rum braun", 4f,
				Unit.CL), new Ingredient("Rum 70%", 2f, Unit.CL),
				new Ingredient("Orangenlikör", 2f, Unit.CL), new Ingredient(
						"Maracujasirup", 2f, Unit.CL), new Ingredient(
						"Grenadine", 2f, Unit.CL), new Ingredient(
						"Zitronensaft", 4f, Unit.CL), new Ingredient(
						"Orangensaft", 4f, Unit.CL), new Ingredient(
						"Ananassaft", 4f, Unit.CL));

		marshal(new File(resourceLocation + "data.xml"), new CocktailContainer(sexOnTheBeach, nic,
				zombie));
	}

	protected static void marshal(final File file, final CocktailContainer cc) {
		try {
			JAXBContext jaxbContext = JAXBContext
					.newInstance(CocktailContainer.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			// pretty output
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(cc, file);
		} catch (final JAXBException e) {
			e.printStackTrace();
		}
	}

	protected static CocktailContainer unmarshal(final File file) {
		try {
			JAXBContext jaxbContext = JAXBContext
					.newInstance(CocktailContainer.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			return (CocktailContainer) jaxbUnmarshaller.unmarshal(file);
		} catch (final JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}
}
