package pl.edu.agh.school;

import java.beans.PropertyEditorSupport;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.edu.agh.school.dao.ClassDAO;
import pl.edu.agh.school.dao.TeacherDAO;
import pl.edu.agh.school.models.Class;
import pl.edu.agh.school.models.Teacher;

@Controller
public class ClassController {

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	ClassDAO classDAO;
	@Autowired
	TeacherDAO teacherDAO;

	@RequestMapping(value = "/addClass", method = RequestMethod.GET)
	public String addClass(Model model, HttpServletRequest request) {

		model.addAttribute("class", new Class());

		return "addClass";
	}

	
	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {
		binder.registerCustomEditor(Class.class, "schoolClass",
				new PropertyEditorSupport() {
					@Override
					public void setAsText(String text) {
						setValue((text.equals("")) ? null : classDAO
								.getClass(Integer.parseInt((String) text)));
					}
				});
	}
	
	@Transactional
	@RequestMapping(value = "/addClass", method = RequestMethod.POST)
	public String AddNewClass(@Valid @ModelAttribute("class") Class newClass,
			BindingResult errors, Model model, HttpServletRequest request) {
		if (errors.hasErrors()) {
			model.addAttribute("schoolClass", newClass);
			return "addClass";
		}
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
	public String deleteClass(Model model, HttpServletRequest request,
			RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("message",
				"Klasa została usunięta.");
		classDAO.removeClass(Integer.parseInt(request.getParameter("id")));
		return "redirect:/classes";
	}
	
	@Transactional
	@RequestMapping(value = "/editClass", method = RequestMethod.GET)
	public String editTeacher(Model model, HttpServletRequest request) {

		Class stClass = classDAO.getClass(Integer.parseInt(request
				.getParameter("id")));
		model.addAttribute("stClass", stClass);
		System.out.println(teacherDAO);
		
		List<Teacher> teachers = teacherDAO.findAll();
		
		model.addAttribute("teachers", teachers);
		

		
		return "editClass";

	}

	@Transactional
	@RequestMapping(value = "/editClass", method = RequestMethod.POST)
	public String editTeacher(@Valid @ModelAttribute("stClass") Class stClass, BindingResult errors,
			Model model, HttpServletRequest request) {


		if (errors.hasErrors()) {
			return "editClass";
		}
			classDAO.updateClass(stClass);
			model.addAttribute("message", "Klasa  została zmodyfikowana.");
//		
//
		return "editClass";
	}

}
