package pl.edu.agh.school;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@Autowired
	private UserDAO userDAO;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGet(ModelMap model, HttpServletRequest request) {

		User user = (User) request.getSession().getAttribute("user");

		if (user == null) {
			model.addAttribute("login", new Login());
			return "login";
		} else {
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(Model model, Login login, HttpServletRequest request) {

		System.out.println(login.username);
		User user = userDAO.getUser(login.username, login.password);

		if (user != null) {
			request.getSession().setAttribute("user", user);
			return "redirect:/";
		} else {
			model.addAttribute("message", "Niepoprawny login lub hasło.");
			return "login";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logoutGet(ModelMap model, HttpServletRequest request) {

		request.getSession().removeAttribute("user");
		model.addAttribute("message", "Zostałeś wylogowany.");
		model.addAttribute("login", new Login());
		return new ModelAndView("login");
	}
}
