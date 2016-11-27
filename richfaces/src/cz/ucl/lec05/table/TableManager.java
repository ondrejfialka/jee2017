package cz.ucl.lec05.table;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.richfaces.component.SortOrder;

@ManagedBean(name="tableMgr")
@ViewScoped
public class TableManager {
	private SortOrder mealNameOrder = SortOrder.unsorted;

	public SortOrder getMealNameOrder() {
		return mealNameOrder;
	}

	public void setMealNameOrder(SortOrder mealNameOrder) {
		this.mealNameOrder = mealNameOrder;
	}
	

}
