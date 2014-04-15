package pl.edu.agh.school;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {
 
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Nieprawidłowy login lub hasło, spróbuj ponownie...");
		}
 
		if (logout != null) {
			model.addObject("msg", "Zostałeś wylogowany ");
		}
		model.setViewName("login");
 
		return model;
		
 
	}

//	@RequestMapping(value="/login", method=RequestMethod.POST)
//	public ModelAndView loginSubmit() {
//	
// 
//		ModelAndView model = new ModelAndView();
//		
//		model.setViewName("main");
// 
//		return model;
//		
//	}
	

}
