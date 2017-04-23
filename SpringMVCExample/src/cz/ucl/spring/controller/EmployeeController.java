package cz.ucl.spring.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.ucl.spring.domain.Employee;

@Controller
public class EmployeeController {

	private static final Logger logger = LoggerFactory
			.getLogger(EmployeeController.class);

	private List<Employee> employees = new LinkedList<>();

	@Autowired
	@Qualifier("employeeValidator")
	private Validator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@ModelAttribute("employee")
	public Employee createEmployeeModel() {
		// ModelAttribute value should be same as used in the empSave.jsp
		return new Employee();
	}

	@RequestMapping(value = "/employee/save", method = RequestMethod.GET)
	public String saveEmployeePage(Model model) {
		logger.info("Returning empSave.jsp page");
		return "empSave";
	}

	@RequestMapping(value = "/employee/save", method = RequestMethod.POST)
	public String saveEmployeeAction(@ModelAttribute("employee") @Validated Employee employee,
			BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			logger.info("Returning empSave.jsp page");	
			return "empSave";
		}
		employees.add(employee);
		model.addAttribute("emp", employee);
		model.addAttribute("empList", employees);
		
		return "empSave";
	}
}