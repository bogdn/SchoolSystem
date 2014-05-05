package pl.edu.agh.school;

import java.beans.PropertyEditorSupport;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.edu.agh.school.dao.ClassDAO;
import pl.edu.agh.school.dao.StudentDAO;
import pl.edu.agh.school.dao.UserDAO;
import pl.edu.agh.school.models.Class;
import pl.edu.agh.school.models.Student;

@Controller
public class StudentController {
	@Autowired
	private ClassDAO classDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private StudentDAO studentDAO;
	
	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {
		binder.registerCustomEditor(Class.class, "studentClass",
				new PropertyEditorSupport() {
					@Override
					public void setAsText(String text) {
						setValue((text.equals("")) ? null : classDAO
								.getClass(Integer.parseInt((String) text)));
					}
				});
	}

	@Transactional
	@RequestMapping(value ="/addStudent",method = RequestMethod.GET)
	public String addStudent(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("allClasses", classDAO.findAll());
		return "addStudent";
		
	}
	
	@Transactional
	@RequestMapping(value ="/addStudent", method = RequestMethod.POST)
	public String addStudentPOST(@Valid Student student, BindingResult errors, Model model, RedirectAttributes redirect,
			HttpServletRequest request) {
		model.addAttribute("student", student);
		if(errors.hasErrors()) {
			return "addStudent";
		}
		if(userDAO.isUserNameAvailable(student.getUsername())) {
			redirect.addFlashAttribute("message", "Uczeń dodany pomyślnie");
			studentDAO.saveStudent(student);
			return "redirect:/students";
			
		}
		else {
			model.addAttribute("message", "Nazwa użytkownika jest zajęta");
			return "addStudent";
		}
		
		
	}
	@Transactional
	@RequestMapping(value="/students", method = RequestMethod.GET)
	public String listStudents(Model model) {
		model.addAttribute("students", studentDAO.findAll());
		return "students";
	}
}
