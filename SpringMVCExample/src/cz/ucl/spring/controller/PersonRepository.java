package cz.ucl.spring.controller;

import org.springframework.stereotype.Component;

import cz.ucl.spring.domain.IceCream;
import cz.ucl.spring.domain.Person;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class PersonRepository {

	private Map<Integer, Person> persons;

	PersonRepository(){
		persons = new HashMap<>();
		Person p = new Person();
		p.setId(1);
		p.setFavouriteIceCreams(Arrays.asList(IceCream.CHOCOLATE.name()));
		persons.put(p.getId(), p);
	}

	public void savePerson(Person person){
		persons.put(person.getId(), person);
	}

	public Person getPerson(Integer id){
		return persons.get(id);
	}

	public List<String> getAllIceCreams() {
		return Stream.of(IceCream.values())
			.map(IceCream::name)
			.collect(Collectors.toList());
	}
}
