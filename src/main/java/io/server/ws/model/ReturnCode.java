package io.server.ws.model;

import lombok.Getter;

@Getter
public enum ReturnCode {

	SUCCESS(1L, "Operation was successful."),

	OBJECT_NOT_FOUND(-1L, "Application not found.");

	private Long code;
	private String description;

	ReturnCode(final Long code, final String description) {
		this.code = code;
		this.description = description;
	}
}
