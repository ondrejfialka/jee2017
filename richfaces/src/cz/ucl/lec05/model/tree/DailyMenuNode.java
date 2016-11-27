package cz.ucl.lec05.model.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.swing.tree.TreeNode;

import cz.ucl.lec05.model.DailyMenu;

public class DailyMenuNode implements TreeNode {
	private static final String NODE_TYPE_DAILY_MENU = "dailyMenu";
		
	private List<MealListNode> children;
	
	private DailyMenu menu;
	private TreeNode parent;

	private int day;
	
	public DailyMenuNode(TreeNode parent, int day, DailyMenu menu) {
		this.menu = menu;
		this.parent = parent;
		this.day = day;
		
		children = new ArrayList<MealListNode>();
		children.add(new MealListNode(this, "Appetizers", menu.getAppetizers()));
		children.add(new MealListNode(this, "Entrées", menu.getEntrees()));
		children.add(new MealListNode(this, "Desserts", menu.getDesserts()));
	}
			
	public DailyMenu getMenu() {
		return menu;
	}

	public String getType() {
		return NODE_TYPE_DAILY_MENU;
	}		

	@Override
	public boolean isLeaf() {
		return false;
	}

	@Override
	public Enumeration children() {
		return Collections.enumeration(children);
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return children.get(childIndex);
	}

	@Override
	public int getChildCount() {
		return children.size();
	}

	@Override
	public int getIndex(TreeNode node) {
		return children.indexOf(node);
	}

	@Override
	public TreeNode getParent() {
		return parent;
	}
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	
}