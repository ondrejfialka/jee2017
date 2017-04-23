package cz.ucl.spring.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cz.ucl.spring.domain.Student;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

@Controller
public class StudentController {
   /*@RequestMapping(value = "/student", method = RequestMethod.GET)
   public ModelAndView student() {
      return new ModelAndView("student", "student", new Student());
   }*/
   
   @RequestMapping(value = "/student", method = RequestMethod.GET)
   public String student(Model model) {
	  model.addAttribute("student", new Student());	   
      return "student";
   }
   
   @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
   public String addStudent(@ModelAttribute Student student, Model model) {
      model.addAttribute("name", student.getName());
      model.addAttribute("age", student.getAge());
      model.addAttribute("id", student.getId());      
      return "result";
   }
   
   
   @RequestMapping(value = "/addStudentValid", method = RequestMethod.POST)
   public String addStudentValid(@Valid @ModelAttribute Student student, BindingResult bindingResult, ModelMap model) {
	   if (bindingResult.hasErrors()) {
			
			return "student";
		}
	   
      model.addAttribute("name", student.getName());
      model.addAttribute("age", student.getAge());
      model.addAttribute("id", student.getId());
      
      return "result";
   }
}
