package cz.ucl.lec05.tree;

import java.io.Serializable;
import java.util.Collection;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.swing.tree.TreeNode;

import org.richfaces.component.UITree;
import org.richfaces.event.TreeSelectionChangeEvent;

import cz.ucl.le05.common.FoodManager;
import cz.ucl.lec05.model.Meal;
import cz.ucl.lec05.model.tree.MealNode;
import cz.ucl.lec05.model.tree.MenuListNode;

@ManagedBean(name="treeMgr")
@ViewScoped
public class TreeManager implements Serializable {

	@ManagedProperty(value="#{foodMgr}")
	private FoodManager foodMgr;
	
	private TreeNode root;
	
	private Meal selectedMeal;	
	
	public TreeManager() {					
	}
	
	public synchronized TreeNode getRoot() {
		if (root == null) {			
			root = new MenuListNode(null, "Weekly Menu", foodMgr.getWeeklyMenu()); 						
		}
		return root;
	}	

	public void setFoodMgr(FoodManager foodMgr) {
		this.foodMgr = foodMgr;
	}
	
	public void selectionChanged(TreeSelectionChangeEvent selectionChangeEvent) {
		Collection<Object> newSelection = selectionChangeEvent.getNewSelection();
		if (newSelection.size() == 1) {
			Object selectedRowKey = newSelection.iterator().next();
			UITree tree = (UITree) selectionChangeEvent.getSource();
	        tree.setRowKey(selectedRowKey);	        	        
			if (tree.getRowData() instanceof MealNode) {	//for datatree_custom.xhtml
				MealNode selectedMealNode = (MealNode) tree.getRowData();
				selectedMeal = selectedMealNode.getMeal();
			}
			else if (tree.getRowData() instanceof Meal) {	//for datatree_adapter.xhtml
				selectedMeal = (Meal) tree.getRowData();
			}
			else {
				selectedMeal = null;				
			}
		}
		else {
			selectedMeal = null;
		}
	}

	public Meal getSelectedMeal() {
		return selectedMeal;
	}
	
	
}
