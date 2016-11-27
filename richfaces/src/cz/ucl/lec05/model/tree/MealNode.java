package cz.ucl.lec05.model.tree;

import java.util.Enumeration;

import javax.swing.tree.TreeNode;

import cz.ucl.lec05.model.Meal;

public class MealNode implements TreeNode {
	private static final String NODE_TYPE_MEAL = "meal";
	
	private Meal meal;
	private TreeNode parent;
			
	public MealNode(TreeNode parent, Meal meal) {
		super();
		
		this.meal = meal;
		this.parent = parent;
	}		

	public String getType() {
		return NODE_TYPE_MEAL;
	}
	
	public Meal getMeal() {
		return meal;
	}
	
	@Override
	public boolean isLeaf() {
		return true;
	}				

	@Override
	public Enumeration children() {
		throw new IllegalStateException("Not implemented");
	}

	@Override
	public boolean getAllowsChildren() {
		return false;
	}

	@Override
	public TreeNode getChildAt(int arg0) {
		throw new IllegalStateException("Not implemented");
	}

	@Override
	public int getChildCount() {
		return 0;
	}

	@Override
	public int getIndex(TreeNode arg0) {
		throw new IllegalStateException("Not implemented");
	}

	@Override
	public TreeNode getParent() {
		return parent;
	}			

}