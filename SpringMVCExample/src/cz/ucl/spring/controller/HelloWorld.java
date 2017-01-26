package cz.ucl.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
 
 
@Controller
@RequestMapping("/welcome")
public class HelloWorld {
 
/*	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
 
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from HelloWorld.java **********</div><br><br>";
		return new ModelAndView("welcome", "message", message);
	}*/
	
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
 
		String heading = "Spring MVC: How to Access ModelMap Values in a JSP?";
		String result1 = "Hey.. I'm result1.. You are seeing me on welcome page.";
		String result2 = "Hey.. I'm result2.. ";
 
		String credit = "Demo by <a href='http://crunchify.com'>Crunchify</a>. Click <a href='http://crunchify.com/category/java-web-development-tutorial/'>here</a> for more than 350 Java Examples.";
 
		// you can add any Collection Objects to ModelMap
		// including JSON, String, Array, Map, List, etc...
		model.addAttribute("heading", heading);
		model.addAttribute("result1", result1);
		model.addAttribute("result2", result2);
		model.addAttribute("credit", credit);
		return "welcome";
	}
}