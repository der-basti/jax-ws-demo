package io.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * The basic cocktail entry.
 * 
 * @author s7n
 */
@XmlType(propOrder = { "name", "description", "ingredients"})
@Getter
@Setter
public class Cocktail {

	@XmlAttribute
	@Setter(value = AccessLevel.NONE)
	private Long id;

	private String name;

	private String description;

	@XmlElementWrapper(name = "ingredients")
	@XmlElement(name = "ingredient")
	@Setter(value = AccessLevel.NONE)
	private List<Ingredient> ingredients;

	@SuppressWarnings("unused")
	private Cocktail() {
		// hidden default constructor for jaxb
	}

	public Cocktail(final String name, final String description,
			final Ingredient... ingredients) {
		this.id = new Random().nextLong();
		this.name = name;
		this.description = description;
		if (ingredients != null) {
			this.ingredients = Arrays.asList(ingredients);
		} else {
			this.ingredients = new ArrayList<>();
		}
	}
}
