package cz.ucl.cdi.bean;

public enum CountryOfResidence {
    CZECH_REPUBLIC,
    SLOVAKIA,
    ENGLAND,
    CHINA,
    GERMANY;
    
    public boolean isInEU() {
        switch(this) {
        case CHINA:
            return false;
        default: 
            return true;
        }
    }
}
