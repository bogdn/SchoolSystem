package pl.edu.agh.school;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.edu.agh.school.models.Class;

@Controller
public class ClassController {

	@Autowired
	SessionFactory sessionFactory;
	
	@RequestMapping(value = "/addClass", method = RequestMethod.GET)
	public String addClass(Model model, HttpServletRequest request) {
		
		model.addAttribute("class", new Class());
		
			return "addClass";
	}
	
	@Transactional
	@RequestMapping(value = "/addClass", method = RequestMethod.POST)
	public String AddNewClass(@ModelAttribute("class")Class newClass, Model model, HttpServletRequest request) {
		
		sessionFactory.getCurrentSession().save(newClass);
		
		model.addAttribute("message", "Klasa została dodana");
		model.addAttribute("schoolClass", newClass);
		System.out.println(model);
			return "showClass";
	}
	
}
