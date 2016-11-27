package cz.ucl.lec05.model;

import java.io.Serializable;

public class Meal implements Serializable {
	private MealCategory category;
	private String name;
	private Double price;	
	
	public Meal(MealCategory category, String name, Double price) {
		this.category = category;
		this.name = name;
		this.price = price;
	}

	public MealCategory getCategory() {
		return category;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}
	
	public String myMethod1() {
		return "ahaha";
	}
	
	public String myMethod2(String param) {
		return "hihihi" + param;
	}
	
	
}
