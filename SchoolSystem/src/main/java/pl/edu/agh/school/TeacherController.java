package pl.edu.agh.school;

import java.beans.PropertyEditorSupport;
import java.util.List;

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
import pl.edu.agh.school.dao.RoleDAO;
import pl.edu.agh.school.dao.TeacherDAO;
import pl.edu.agh.school.dao.UserDAO;
import pl.edu.agh.school.models.Class;
import pl.edu.agh.school.models.Teacher;

@Controller
public class TeacherController {

	@Autowired
	ClassDAO classDAO;
	
	@Autowired
	TeacherDAO teacherDAO;
	
	@Autowired 
	RoleDAO roleDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {
	        binder.registerCustomEditor(Class.class, "schoolClass", new PropertyEditorSupport() {
	         @Override
	         public void setAsText(String text) {
	            setValue((text.equals(""))?null:classDAO.getClass(Integer.parseInt((String)text)));
	         }
	     });
	}
	
	@Transactional
	@RequestMapping(value="/addTeacher", method = RequestMethod.GET)
	public String addTeacher(Model model, HttpServletRequest request) {
		
		model.addAttribute("teacher", new Teacher());
		model.addAttribute("classes", classDAO.findAll());
			return "addTeacher";
	}
	
	@Transactional
	@RequestMapping(value = "/addTeacher", method = RequestMethod.POST)
	public String AddNewTeacher(@Valid Teacher teacher, BindingResult errors, Model model, HttpServletRequest request) {
		
		model.addAttribute("teacher", teacher);
		
		if (errors.hasErrors()) {
			return "addTeacher";
		}
		
		if(userDAO.isUserNameAvailable(teacher.getUsername()))
		{
			teacher.setRole(roleDAO.getRole("ROLE_TEACHER"));
			teacherDAO.saveTeacher(teacher);
			model.addAttribute("teacher", new Teacher());
			model.addAttribute("message", "Nauczyciel " +teacher.getName() +" " + teacher.getSurname() + " został dodany.");
		}
		else
		{
			model.addAttribute("message", "Nazwa użytkownika jest zajęta.");
		}
		
			return "addTeacher";
	}
	
	@RequestMapping(value="/teachers", method = RequestMethod.GET)
	public String getTeachers(Model model) {
		
		List<Teacher> teachers = teacherDAO.findAll();
		model.addAttribute("teachers", teachers);
		return "teachers";
		
	}
	
	@Transactional
	@RequestMapping(value = "/deleteTeacher", method = RequestMethod.GET)
	public String deleteTeacher(Model model, HttpServletRequest request,
			RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("message",
				"Nauczyciel został usunięty.");
		teacherDAO.removeTeacher(teacherDAO.getTeacher(Integer.parseInt(request.getParameter("id"))));
		return "redirect:/classes";
	}
}
