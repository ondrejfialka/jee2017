package cz.ucl.jee.lec03;


public class RodneCislo {
	private String prefix;
	private String suffix;

	public enum Sex {MALE, FEMALE};
	
	public RodneCislo() {
	}

	public RodneCislo(String prefix, String suffix) {
		setPrefix(prefix);
		setSuffix(suffix);
	}

	public String toString() {
		return prefix + "/" + suffix;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		if (!prefix.matches("[0-9]{2,2}[0156][0-9][0-3][0-9]"))
			throw new RuntimeException("Wrong RC prefix (should be yymmdd): "
					+ prefix);
		else
			this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		if (!suffix.matches("[0-9]{4,4}"))
			throw new RuntimeException("Wrong RC suffix (should be yymmdd): "
					+ suffix);
		else
			this.suffix = suffix;
	}

	private Sex getSex() {
		if ((prefix.charAt(2) == '5') || (prefix.charAt(2) == '6')) {
			return Sex.FEMALE;
		} else if ((prefix.charAt(2) == '0') || (prefix.charAt(2) == '1')) {
			return Sex.MALE;
		} else {
			throw new RuntimeException("Wrong RC format, not male or female: "
					+ prefix + "/" + suffix);
		}
	}

	public boolean isMale() {
		return (Sex.MALE == getSex());
	}

	public boolean isFemale() {
		return (Sex.FEMALE == getSex());
	}

}
