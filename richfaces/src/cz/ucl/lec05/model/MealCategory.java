package cz.ucl.lec05.model;

public enum MealCategory {
	APPETIZER, ENTREE, DESSERT, SOFT_DRINK, HOT_BEVERAGE;
	
	public String getName() {
		return this.toString();
	}
}
