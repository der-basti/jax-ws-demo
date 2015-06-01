package io.server.ws.samples;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlType(name = "FaultException", propOrder = { "message" })
@XmlAccessorType(XmlAccessType.FIELD)
public class FaultException {

	protected String message;
}
