package cz.ucl.spring.domain;

import java.util.List;

public class Person{

	Integer id;
	List<String> favouriteIceCreams;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<String> getFavouriteIceCreams() {
		return favouriteIceCreams;
	}

	public void setFavouriteIceCreams(List<String> favouriteIceCreams) {
		this.favouriteIceCreams = favouriteIceCreams;
	}
}