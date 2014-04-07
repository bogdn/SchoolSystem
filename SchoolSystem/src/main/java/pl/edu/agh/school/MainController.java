package pl.edu.agh.school;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request) {

		User user = (User) request.getSession().getAttribute("user");

//		if (user == null) {
//			return "redirect:/login";
//		} else {
			return "main";
//		}

	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homeTest(Model model, HttpServletRequest request) {

		User user = (User) request.getSession().getAttribute("user");

//		if (user == null) {
//			return "redirect:/login";
//		} else {
			return "main";
//		}

	}
	

}