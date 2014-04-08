package pl.edu.agh.school;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.edu.agh.school.models.Teacher;

@Controller
public class TeacherController {

	@RequestMapping(value="/addTeacher", method = RequestMethod.GET)
	public String addTeacher(Model model, HttpServletRequest request) {
		
		model.addAttribute("teacher", new Teacher());
		
			return "addClass";
	}
	
}
