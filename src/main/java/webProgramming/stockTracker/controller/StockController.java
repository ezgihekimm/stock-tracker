package webProgramming.stockTracker.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import webProgramming.stockTracker.model.Product;
import webProgramming.stockTracker.service.StockService;
import webProgramming.stockTracker.validator.FieldSizeValidator;

@Controller
public class StockController {

	@Autowired
	private StockService service;
	
	@Autowired
	FieldSizeValidator fmv;
	

	 @GetMapping("form.html")
	    public ModelAndView displayForm(HttpServletRequest request) {
	        Locale locale = RequestContextUtils.getLocale(request);
	        ModelAndView mv = new ModelAndView("form");
	        mv.addObject("product", new Product());
	        mv.addObject("lang", locale.getLanguage());

	        return mv;
	    }
	 
	@PostMapping("/send")
	public ModelAndView processForm(@Valid @ModelAttribute Product product, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("product", product);
		
		fmv.validate(product, result);

		if (result.hasErrors())
			mv.setViewName("form");
		else {
			mv.setViewName("person-list");
			service.create(product);
			mv.addObject("product", service.findAll());
		}

		return mv;
	}

	@GetMapping("list.html")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("person-list");
		mv.addObject("product", service.findAll());
		
		return mv;
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable long id) {
		ModelAndView mv = new ModelAndView("person-list");
		service.delete(id);
		mv.addObject("product", service.findAll());
			
		return mv;
	}

}
