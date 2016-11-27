package cz.ucl.jee.lec04;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.component.StateHolder;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("rcConverter")
public class RCConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private String delimiter = "/";

	public Object getAsObject(FacesContext ctx, UIComponent convertFrom,
			String value) {
		String[] splitValues = value.split(delimiter);
		if (splitValues.length != 2) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Wrong format",
					"Wrong format of rodne cislo '" + value + "'");
			throw new ConverterException(message);
		} else {
			try {
				RodneCislo result = new RodneCislo(splitValues[0],
						splitValues[1]);
				return result;
			} catch (RuntimeException e) {
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Wrong format",
						"Wrong format of rodne cislo '" + value + "'");
				throw new ConverterException(message);
			}
		}

	}

	public String getAsString(FacesContext ctx, UIComponent convertTo,
			Object value) {
		RodneCislo rc = (RodneCislo) value;
		return rc.getPrefix() + delimiter + rc.getSuffix();
	}

	public String getDelimiter() {
		return delimiter;
	}

	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}		

}
