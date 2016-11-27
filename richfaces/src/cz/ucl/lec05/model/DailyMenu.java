package cz.ucl.lec05.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DailyMenu implements Serializable{
	private static final String CATEGORY_APPETIZERS = "appetizers";
	private static final String CATEGORY_ENTREES = "entrees";
	private static final String CATEGORY_DESSERTS = "desserts";
	
	private List<Meal> appetizers;
	private List<Meal> entrees;
	private List<Meal> desserts;
	private String theme;
	
	public DailyMenu(String theme) {
		appetizers = new ArrayList<Meal>();
		entrees = new ArrayList<Meal>();
		desserts = new ArrayList<Meal>();
		this.theme = theme;
	}
	
	public List<Meal> getAppetizers() {
		return appetizers;
	}
	public void setAppetizers(List<Meal> appetizers) {
		this.appetizers = appetizers;
	}
	public List<Meal> getEntrees() {
		return entrees;
	}
	public void setEntrees(List<Meal> entrees) {
		this.entrees = entrees;
	}
	public List<Meal> getDesserts() {
		return desserts;
	}
	public void setDesserts(List<Meal> desserts) {
		this.desserts = desserts;
	}
	
	public void addMeal(Meal meal) {
		switch(meal.getCategory()) {
		case APPETIZER:
			if(!appetizers.contains(meal)) {
				appetizers.add(meal);				
			}
			break;
		case ENTREE:
			if (!entrees.contains(meal)) {
				entrees.add(meal);
			}
			break;
		case DESSERT:
			if (!desserts.contains(meal)) {
				desserts.add(meal);
			}
			break;
		}
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}
	
	public List<Meal> getAllMeals() {
		List<Meal> result = new ArrayList<Meal>();
		result.addAll(getAppetizers());
		result.addAll(getEntrees());
		result.addAll(getDesserts());
		return result;
	}

}
