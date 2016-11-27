package cz.ucl.le05.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.richfaces.event.DropEvent;

import cz.ucl.lec05.model.DailyMenu;
import cz.ucl.lec05.model.Meal;
import cz.ucl.lec05.model.MealCategory;

@ManagedBean(name="foodMgr")
@SessionScoped
public class FoodManager implements Serializable {
	private List<DailyMenu> weeklyMenu;
	private List<Meal> allMeals;
	private String mealFilter;
	
	public FoodManager() {
		allMeals = new ArrayList<Meal>();
		allMeals.add(new Meal(MealCategory.APPETIZER, "Salmon Pasta Salad", 10.30d));
		allMeals.add(new Meal(MealCategory.APPETIZER, "Blue Cheese Chicken Caesar Salad", 4.20d));
		allMeals.add(new Meal(MealCategory.APPETIZER, "Pigs in a blanket", 7.30d));
		allMeals.add(new Meal(MealCategory.ENTREE, "Creamy Chicken in Pastry Shell", 23.30d));
		allMeals.add(new Meal(MealCategory.ENTREE, "Pork Wellington with Raspberry Chipotle Sauce", 25.40d));
		allMeals.add(new Meal(MealCategory.ENTREE, "Sausage Stuffed Bread Bowls", 33.45d));
		allMeals.add(new Meal(MealCategory.ENTREE, "Chicken Wings with Blue Cheese Sauce", 18.90d));
		allMeals.add(new Meal(MealCategory.DESSERT, "Pierogies", 4.30d));
		allMeals.add(new Meal(MealCategory.DESSERT, "Whole Wheat Pancake", 3.80d));
		
		weeklyMenu = new ArrayList<DailyMenu>(5);
		weeklyMenu.add(new DailyMenu("Chinese"));
		weeklyMenu.add(new DailyMenu("Fast Food"));
		weeklyMenu.add(new DailyMenu("Traditional Czech"));
		weeklyMenu.add(new DailyMenu("Vegetarian"));
		weeklyMenu.add(new DailyMenu("Fish"));		
		
		weeklyMenu.get(0).addMeal(allMeals.get(2));
		weeklyMenu.get(0).addMeal(allMeals.get(3));
		weeklyMenu.get(0).addMeal(allMeals.get(5));
		weeklyMenu.get(1).addMeal(allMeals.get(1));
		weeklyMenu.get(1).addMeal(allMeals.get(4));
		weeklyMenu.get(1).addMeal(allMeals.get(3));
		weeklyMenu.get(2).addMeal(allMeals.get(1));
		weeklyMenu.get(2).addMeal(allMeals.get(2));
		weeklyMenu.get(2).addMeal(allMeals.get(4));
		weeklyMenu.get(0).addMeal(allMeals.get(5));

	}

	public List<DailyMenu> getWeeklyMenu() {
		return weeklyMenu;
	}
	
	public List<Meal> getAllMeals() {
		return allMeals;
	}
		
	
	public static String dayOfWeekName(int idx) {
		return "dayOfWeek." + idx;
	}

	public String getMealFilter() {
		return mealFilter;
	}

	public void setMealFilter(String mealFilter) {
		this.mealFilter = mealFilter;
	}
	
	public MealCategory getAcceptedTypes(){
		return MealCategory.ENTREE;
	}
	
}
