package pl.edu.agh.school;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.edu.agh.school.dao.ClassDAO;
import pl.edu.agh.school.dao.StudentDAO;
import pl.edu.agh.school.dao.SubjectDAO;

@Controller
public class GradeBookController {
	@Autowired
	private ClassDAO classDAO;
	@Autowired
	private SubjectDAO subjectDAO;
	@Autowired
	private StudentDAO studentDAO;
	
	@RequestMapping(value = "/listClasses", method=RequestMethod.GET)
	public String listAllClasses(Model model) {
		
		model.addAttribute("allClasses", classDAO.findAll());
		return "listClasses";
		
	}
	
	@RequestMapping(value="/subjectsOfClass", method = RequestMethod.GET)
	public String listSubjectsOfClass(Model model, HttpServletRequest request) {
		int classID = Integer.parseInt(request.getParameter("id"));
		model.addAttribute("subjects", subjectDAO.getSubjectsFromClass(classID));
		return "subjectsOfClass";
		
	}
	@RequestMapping(value = "/listStudents", method=RequestMethod.GET)
	public String listStudents(Model model, HttpServletRequest request) {
		int classID = Integer.parseInt(request.getParameter("id"));
		model.addAttribute("students", classDAO.getStudentsFromClass(classID));
		
		return "listStudents";
	}

}
