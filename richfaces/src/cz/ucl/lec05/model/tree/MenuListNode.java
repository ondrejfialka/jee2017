package cz.ucl.lec05.model.tree;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

import cz.ucl.lec05.model.DailyMenu;

public class MenuListNode extends GenericListNode {		
	
	public MenuListNode(TreeNode parent, String name, List<DailyMenu> menuList) {
		super(parent, "menuList", name);
		items = new ArrayList<TreeNode>();
		for(int i=0; i<menuList.size();i++) {
			items.add(new DailyMenuNode(this,i, menuList.get(i)));
		}
		
	}
			

}