package br.com.infinitusProject.infinitusProject.controllers;


import java.io.IOException;

<<<<<<< HEAD
import javax.servlet.http.HttpSession;
=======
>>>>>>> 25586146239f0c79e1059290c83e8f4cd288f9b9
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.ModelAttribute;
=======
>>>>>>> 25586146239f0c79e1059290c83e8f4cd288f9b9
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.infinitusProject.infinitusProject.models.User;
import br.com.infinitusProject.infinitusProject.services.UserService;
import br.com.infinitusProject.infinitusProject.infra.AccessHistory;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
<<<<<<< HEAD
	public ModelAndView login(User user) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("loginRegister");
=======
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
>>>>>>> 25586146239f0c79e1059290c83e8f4cd288f9b9
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration() {
<<<<<<< HEAD
		ModelAndView modelAndView = new ModelAndView();		
		User user = new User(); 
		modelAndView.addObject("user", user);
		modelAndView.setViewName("loginRegister");
=======
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
>>>>>>> 25586146239f0c79e1059290c83e8f4cd288f9b9
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
<<<<<<< HEAD
	public ModelAndView createNewUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult /*, Model model*/) {
=======
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
>>>>>>> 25586146239f0c79e1059290c83e8f4cd288f9b9
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user",
<<<<<<< HEAD
					"E-mail já existente!");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("loginRegister");
		} else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "Usuário cadastrado com sucesso!");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("loginRegister");

		}		
		/*model.addAttribute("user", new User());*/ 
=======
					"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("registration");

		}
>>>>>>> 25586146239f0c79e1059290c83e8f4cd288f9b9
		return modelAndView;
	}

	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName",
				"Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
<<<<<<< HEAD
		modelAndView.addObject("adminMessage", "Conteúdo disponível apenas para admins.");
=======
		modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
>>>>>>> 25586146239f0c79e1059290c83e8f4cd288f9b9
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}

	@RequestMapping(value = "/homeUser", method = RequestMethod.GET)
<<<<<<< HEAD
	public ModelAndView homeUser(HttpSession session) throws IOException {
=======
	public ModelAndView homeUser() throws IOException {
>>>>>>> 25586146239f0c79e1059290c83e8f4cd288f9b9
		
		AccessHistory accessHistory = new AccessHistory();
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName",
				"Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
<<<<<<< HEAD
		modelAndView.addObject("userMessage", "Infinitus Books Principal Page!");
		modelAndView.setViewName("homeUser");	
		
		session.setAttribute("name", user.getName());
		session.setAttribute("lastName", user.getLastName());
		session.setAttribute("email", user.getEmail());
		session.setAttribute("zipcode", user.getZipCode());
		session.setAttribute("state", user.getState());
		session.setAttribute("neighborhood", user.getNeighborhood());
		session.setAttribute("address", user.getAddress());
		session.setAttribute("readlike", user.getReadlike());
				
=======
		modelAndView.addObject("userMessage", "You just entered Infinitus Books Principal Page!");
		modelAndView.setViewName("homeUser");	
		
>>>>>>> 25586146239f0c79e1059290c83e8f4cd288f9b9
		accessHistory.historyLog(user.getEmail());
		
		return modelAndView;

	}

}