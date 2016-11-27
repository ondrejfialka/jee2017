package cz.ucl.lec05.iteration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SelectUtil implements Serializable {
	private Map<String,String> maritalStatus;
	
	public SelectUtil() {
		maritalStatus = new TreeMap<String, String>();
		maritalStatus.put("single", "single");
		maritalStatus.put("married", "married");
		maritalStatus.put("divorced", "divorced");
		maritalStatus.put("widowed", "widowed");
		maritalStatus.put("unmarried partners", "partner");
		maritalStatus.put("","none");
	}

	public Map<String, String> getMaritalStatusMap() {
		return maritalStatus;
	}
	
	public List<String> getMaritalStatusList() {
		return new ArrayList<String>(maritalStatus.keySet());  //SortedSet<String>, protože používáme TreeMap<String,String>
	}
	
	public void addStatus(String code, String name) {
		maritalStatus.put(code, name);
	}
	
	public void removeStatus(String code) {
		for(String name : maritalStatus.keySet()) {
			if (code != null && code.equals(maritalStatus.get(name))) {
				maritalStatus.remove(name);
				return;
			}
		}		
	}
}
