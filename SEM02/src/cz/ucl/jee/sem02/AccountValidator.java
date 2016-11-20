package cz.ucl.jee.sem02;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

import cz.ucl.jee.accounts.AccountService;

@Named
@RequestScoped
public class AccountValidator implements Validator {

	@Inject
	AccountService accountService;
	
	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {		
		if (!accountService.accountExists(value.toString())){
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid account number", "Invalid account number"));
		}
	}

}
