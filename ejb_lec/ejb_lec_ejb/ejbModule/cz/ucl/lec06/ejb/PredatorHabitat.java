package cz.ucl.lec06.ejb;

import javax.ejb.Remote;

@Remote
public interface PredatorHabitat {
 //Začni práci s výběhem, identifikovaným jménem
 public void openHabitat(String name);

 //Nastav teplotu ve výběhu
 public void setTemperature(Double newTemperature);

 //Vhoď do výběhu krmení, složené z masa a salátu
 public void feed(Double meatWeight, Double saladWeight);

 //Ukonči práci s výběhem
 public void closeHabitat();

Double getTemperature();
} 