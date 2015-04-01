package io.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;

/**
 * Collect all the cocktails.
 * 
 * @author s7n
 */
@XmlRootElement
@Getter
public class CocktailContainer {

	// @XmlElementWrapper(name = "cocktails")
	@XmlElement(name = "cocktail")
	private List<Cocktail> cocktails;

	@SuppressWarnings("unused")
	private CocktailContainer() {
		// hidden constructor for jaxb
	}

	public CocktailContainer(final Cocktail... cocktails) {
		if (cocktails != null) {
			this.cocktails = Arrays.asList(cocktails);
		} else {
			this.cocktails = new ArrayList<>();
		}
	}
}
