package cz.ucl.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cz.ucl.spring.domain.Person;

import java.util.List;

/**
 * Created by ext96975 on 25.04.2017.
 */
@Controller
@RequestMapping("/person")
public class IceCreamController {
	//http://localhost:8080/person?personId=1
	@Autowired
	PersonRepository repository;

	@RequestMapping(method= RequestMethod.GET)
	public String loadForEdit(Model model){
		return "person";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String save(@ModelAttribute("person") Person person){
		repository.savePerson(person);

		return "person";
	}

	//called by the framework on 'get' to load the person you wish to edit
	//called by the framework on on 'post' to get the same instance for binding
	//send personId as a hidden form element in the form
	@ModelAttribute("person")
	public Person getPerson(@RequestParam int personId){
		return repository.getPerson(personId);
	}

	@ModelAttribute("iceCreams")
	public List<String> getAvailableIceCreams(){
		return repository.getAllIceCreams();
	}
}
