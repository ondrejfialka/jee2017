package cz.ucl.lec05.iteration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import cz.ucl.lec05.model.MaritalStatus;

@ManagedBean(name="iterationMgr")
@ViewScoped
public class IterationManager implements Serializable{
	private SelectUtil selectUtil;
	
	private String selectedItemRadio;
	private String selectedItemMenu;
	
	public IterationManager() {
		selectUtil = new SelectUtil();
	}
	
	public String getSelectedItemRadio() {
		return selectedItemRadio;
	}
	
	public void setSelectedItemRadio(String selectedItemRadio) {
		this.selectedItemRadio = selectedItemRadio;
	}
	
	public String getSelectedItemMenu() {
		return selectedItemMenu;
	}
	
	public void setSelectedItemMenu(String selectedItemMenu) {
		this.selectedItemMenu = selectedItemMenu;
	}
	
	public SelectUtil getData() {
		return selectUtil;
	}
	
	public void removeSelectedItemMenu() {
		if (!"none".equals(selectedItemMenu)) {
			selectUtil.removeStatus(selectedItemMenu);
		}
	}
	
	public List<MaritalStatus> getMaritalStatusEnumValues() {
		List<MaritalStatus> result = new ArrayList<MaritalStatus>();
		result.addAll(Arrays.asList(MaritalStatus.values()));
		Collections.sort(result);
		result.remove(MaritalStatus.NONE);
		return result;
	}
	
}
