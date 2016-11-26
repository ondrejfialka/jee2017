package cz.ucl.jee.lec03;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("rcConverter")
public class RCConverter implements Converter {
	private static final String DELIMITER = "/";

	public Object getAsObject(FacesContext ctx, UIComponent convertFrom,
			String value) {
		String[] splitValues = value.split(DELIMITER);
		ResourceBundle bundle = ResourceBundle.getBundle("error_messages");
		
		if (splitValues.length != 2) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Wrong format",
					bundle.getString("wrongBirthNumber"));
			throw new ConverterException(message);
		} else {
			try {
				RodneCislo result = new RodneCislo(splitValues[0],
						splitValues[1]);
				return result;
			} catch (RuntimeException e) {
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Wrong format",
						bundle.getString("wrongBirthNumber"));
				throw new ConverterException(message);
			}
		}

	}

	public String getAsString(FacesContext ctx, UIComponent convertTo,
			Object value) {
		RodneCislo rc = (RodneCislo) value;
		return rc.getPrefix() + DELIMITER + rc.getSuffix();
	}

}
