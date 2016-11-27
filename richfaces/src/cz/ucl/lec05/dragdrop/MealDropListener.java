package cz.ucl.lec05.dragdrop;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.richfaces.event.DropEvent;

import cz.ucl.lec05.model.DailyMenu;
import cz.ucl.lec05.model.Meal;

@ManagedBean(name="mealDropListener")
@RequestScoped
public class MealDropListener{

	public void processDrop(DropEvent evt) {
		DailyMenu menu = (DailyMenu) evt.getDropValue();
		Meal meal = (Meal) evt.getDragValue();
		menu.addMeal(meal);
	}

}
