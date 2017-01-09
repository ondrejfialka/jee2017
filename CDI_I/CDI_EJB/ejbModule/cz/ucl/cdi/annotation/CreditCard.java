package cz.ucl.cdi.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

@Target({TYPE, METHOD, PARAMETER, FIELD})
@Retention(RUNTIME)
@Qualifier
public @interface CreditCard {

}
