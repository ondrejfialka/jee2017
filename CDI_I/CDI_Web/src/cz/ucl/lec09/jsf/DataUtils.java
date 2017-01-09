package cz.ucl.lec09.jsf;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import cz.ucl.cdi.bean.PaymentType;

@ApplicationScoped
@Named
public class DataUtils {
	public List<PaymentType> getPaymentTypeEnumValues() {
		return Arrays.asList(PaymentType.values());
	}
}
