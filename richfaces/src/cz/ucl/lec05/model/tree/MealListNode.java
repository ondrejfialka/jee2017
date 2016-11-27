package cz.ucl.lec05.model.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.swing.tree.TreeNode;

import cz.ucl.lec05.model.Meal;

public class MealListNode extends GenericListNode {	
	
	private TreeNode parent;
	private List<MealNode> items;
	
	public MealListNode(TreeNode parent, String name, List<Meal> mealList) {
		super(parent, "mealList", name);
		
		items = new ArrayList<MealNode>();
		for(Meal m : mealList) {
			items.add(new MealNode(this, m));
		}
		
		this.parent = parent;
	}
	
	@Override
	public boolean isLeaf() {
		return items.isEmpty();
	}
	
	@Override
	public Enumeration children() {
		return Collections.enumeration(items);
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return items.get(childIndex);
	}

	@Override
	public int getChildCount() {
		return items.size();
	}

	@Override
	public int getIndex(TreeNode node) {
		return items.indexOf(node);
	}

	@Override
	public TreeNode getParent() {
		return parent;
	}
		
}