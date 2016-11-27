package cz.ucl.jee.lec04;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("emailValidator")
public class EmailValidator implements Validator, Serializable {

	private static final long serialVersionUID = 1L;
	private Set<String> bannedDomains;
//	private boolean isTransient;
	
	private static final String VALID_REGEX = ".+@.+\\.[a-zA-Z]{2,4}";


	public EmailValidator() {
		super();
		bannedDomains=new HashSet<String>();
	}

	public void validate(FacesContext ctx, UIComponent component, Object value)
			throws ValidatorException {
		if(value!=null && value instanceof String) {
			String email = (String) value;
			if (email.matches(VALID_REGEX)) {
				String domain = email.substring(email.lastIndexOf('.')+1);
				if (bannedDomains.contains(domain)) {
					throw new ValidatorException(new FacesMessage("Banned domain","The e-mail address '"+(email)+"' comes from a banned domain."));
				}
			} else {
				throw new ValidatorException(new FacesMessage("Wrong e-mail format","The e-mail address '"+(email)+"' isn't properly formatted."));
			}
		} else {
			throw new ValidatorException(new FacesMessage("Unknown error","Unknown validation error for email address: " + value));
		}

	}
	
	public void setBannedDomains(String unparsedDomains) {
		if(unparsedDomains!=null) {
			String[] parsedDomains = unparsedDomains.split(",");
			for(String i : parsedDomains) bannedDomains.add(i);
		}
	}	
		
}
