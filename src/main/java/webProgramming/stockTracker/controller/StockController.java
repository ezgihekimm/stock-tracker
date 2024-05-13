package webProgramming.stockTracker.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import webProgramming.stockTracker.model.Person;
import webProgramming.stockTracker.service.StockService;

@Controller
public class StockController {

	@Autowired
	private StockService service;

	@GetMapping("form.html")
	public ModelAndView displayForm() {
		ModelAndView mv = new ModelAndView("form");
		mv.addObject("person", new Person());

		return mv;
	}

	@PostMapping("/send")
	public ModelAndView processForm(@Valid @ModelAttribute Person person, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("person", person);

		if (result.hasErrors())
			mv.setViewName("form");
		else {
			mv.setViewName("person-list");
			service.create(person);
			mv.addObject("persons", service.findAll());
		}

		return mv;
	}

	@GetMapping("list.html")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("person-list");
		mv.addObject("persons", service.findAll());
		
		return mv;
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable long id) {
		ModelAndView mv = new ModelAndView("person-list");
		service.delete(id);
		mv.addObject("persons", service.findAll());
			
		return mv;
	}

}
