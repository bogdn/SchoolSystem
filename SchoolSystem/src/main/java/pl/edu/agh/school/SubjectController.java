package pl.edu.agh.school;

import java.beans.PropertyEditorSupport;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.edu.agh.school.dao.ClassDAO;
import pl.edu.agh.school.dao.SubjectDAO;
import pl.edu.agh.school.dao.TeacherDAO;
import pl.edu.agh.school.models.Class;
import pl.edu.agh.school.models.Subject;
import pl.edu.agh.school.models.Teacher;

@Controller
public class SubjectController {
	@Autowired
	private ClassDAO classDAO;
	
	@Autowired
	private SubjectDAO subjectDAO;
	@Autowired TeacherDAO teacherDAO;
	
	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {
		
		binder.registerCustomEditor(Teacher.class, "teacher",
				new PropertyEditorSupport() {
					@Override
					public void setAsText(String text) {
						setValue((text.equals("")) ? null : teacherDAO
								.getTeacher(Integer.parseInt((String) text)));
					}
				});
		binder.registerCustomEditor(Class.class, "subClass",
				new PropertyEditorSupport() {
					@Override
					public void setAsText(String text) {
						setValue((text.equals("")) ? null : classDAO
								.getClass(Integer.parseInt((String) text)));
					}
				});
		
		
	}
	@Transactional
	@RequestMapping(value="addSubject", method = RequestMethod.GET)
	public String addSubject(Model model) {
		
		model.addAttribute("subject", new Subject());
		model.addAttribute("allClasses", classDAO.findAll());
		model.addAttribute("allTeachers", teacherDAO.findAll());
		return "addSubject";
		
	}
	@Transactional
	@RequestMapping(value="/addSubject", method = RequestMethod.POST)
	public String addSubjectPOST(Subject subject, Model model, RedirectAttributes redirectAttributes) {
		model.addAttribute("subject", subject);
		
		subjectDAO.saveSubject(subject);
		redirectAttributes.addFlashAttribute("message", "Dodano przedmiot");
		
		
		return "redirect:/subjects";
		
	}
	
	@RequestMapping(value="/subjects", method = RequestMethod.GET)
	public String listSubjects(Model model) {
		
		model.addAttribute("subject", new Subject());
		model.addAttribute("subjects", subjectDAO.findAll());
		return "subjects";
		
	}
	@RequestMapping(value="/deleteSubject", method = RequestMethod.GET)
	public String deleteSubject(Model model, RedirectAttributes attributes, HttpServletRequest request) {
		Subject subject = subjectDAO.getSubject((Integer.parseInt(request.getParameter("id"))));
		subjectDAO.removeSubject(subject);
		
		attributes.addFlashAttribute("message", "Przedmiot został usunięty");
		
		
		return "redirect:/subjects";
		
	}
	
	@Transactional
	@RequestMapping(value="/editSubject", method = RequestMethod.GET)
	public String editSubject(Model model, HttpServletRequest request) {
		
		model.addAttribute("subject", subjectDAO.getSubject(Integer.parseInt(request.getParameter("id"))));
		model.addAttribute("allClasses", classDAO.findAll());
		model.addAttribute("allTeachers", teacherDAO.findAll());
		return "editSubject";
		
	}
	@Transactional
	@RequestMapping(value="/editSubject", method = RequestMethod.POST)
	public String editSubjectPOST(@Valid Subject subject, Model model, RedirectAttributes redirectAttributes) {
		
		subjectDAO.updateSubject(subject);
		redirectAttributes.addFlashAttribute("message", "Zmodyfikowano przedmiot");
		
		
		return "redirect:/subjects";
		
	}

}
