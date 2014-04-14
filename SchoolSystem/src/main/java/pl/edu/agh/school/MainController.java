package pl.edu.agh.school;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request) {
			return "main";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homeTest(Model model, HttpServletRequest request) {
		System.out.println();
			return "main";
	}
	
}