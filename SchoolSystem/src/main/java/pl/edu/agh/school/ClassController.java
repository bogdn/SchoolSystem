package pl.edu.agh.school;

import java.util.List;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.edu.agh.school.dao.ClassDAO;
import pl.edu.agh.school.models.Class;

@Controller
public class ClassController {

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	ClassDAO classDAO;
	
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
			return "showClass";
	}
	
	@Transactional
	@RequestMapping(value = "/classes", method = RequestMethod.GET)
	public String classes(Model model, HttpServletRequest request) {
		System.out.println(model);
		List<Class> classes = classDAO.findAll();
		
		model.addAttribute("classes", classes);
			return "classes";
	}
	
	@Transactional
	@RequestMapping(value = "/deleteClass", method = RequestMethod.GET)
	public String deleteClass(Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("message", "Klasa została usunięta.");
		classDAO.removeClass(Integer.parseInt(request.getParameter("id")));
			return "redirect:/classes";
	}
	
}
