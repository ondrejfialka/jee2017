package cz.ucl.jee.accounts;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public enum BankCode {
	KB("0100"),
	CNB("0710"),
	CS("0800"),
	Equa("6100");
	
	private String code;
	
	static final Map<String, BankCode> CODE_MAP;
	
	static {
		CODE_MAP = new HashMap<>();
			
		for (BankCode bankCode : BankCode.values()){
			CODE_MAP.put(bankCode.getCode(), bankCode);
		}
	}
	
	private BankCode(String code){
		this.code = code;
	}
	
	public String getCode(){
		return code;
	}
	
	public BankCode fromStringCode(String stringCode){
		return CODE_MAP.get(stringCode);
	}

}
