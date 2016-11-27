package cz.ucl.lec05.model.tree;

import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.swing.tree.TreeNode;

public abstract class GenericListNode implements TreeNode {	
	protected List<TreeNode> items;
	
	private String name;
	private String listType;
	private TreeNode parent;
	
	public GenericListNode(TreeNode parent, String listType, String name) {
		this.listType = listType;
		this.parent = parent;
		this.name = name;
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
	
	public String getType() {
		return listType;
	}

	public String getName() {
		return name;
	}
	
	
}
