package io.model;

import java.util.Random;

import javax.xml.bind.annotation.XmlAttribute;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * A ingredient entry for a {@link Cocktail}.
 * 
 * @author s7n
 */
@Getter
@Setter
public class Ingredient {

	@XmlAttribute
	@Setter(value = AccessLevel.NONE)
	private Long id;

	private String name;

	private Float quantity;

	private Unit unit;

	@SuppressWarnings("unused")
	private Ingredient() {
		// hidden default constructor for jaxb
	}

	public Ingredient(final String name, final Float quantity, final Unit unit) {
		this.id = new Random().nextLong();
		this.name = name;
		this.quantity = quantity;
		this.unit = unit;
	}
}
