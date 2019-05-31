package br.com.infinitusProject.infinitusProject.controllers;


import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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

	//Larissa - Request GET para exibição da página de Login/Cadastro
	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public ModelAndView login(User user) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("loginRegister");
		return modelAndView;
	}

	//Larissa - Request GET para exibição da página de Cadastro 
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView();		
		User user = new User(); 
		modelAndView.addObject("user", user);
		modelAndView.setViewName("loginRegister");
		return modelAndView;
	}

	//Larissa - Request POST para validação de dados no momento do cadastro
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user",
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
		return modelAndView;
	}

	//Larissa - Request GET para exibição da página de ADMIN realizando validação 
	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName",
				"Olá, " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("adminMessage", "Conteúdo disponível apenas para admins.");
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}

	//Larissa - Request GET para exibição da página Home
	@RequestMapping(value = "/homeBooks", method = RequestMethod.GET)
	public ModelAndView homeBooks(HttpSession session) throws IOException {		
		AccessHistory accessHistory = new AccessHistory();
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName",
				"Olá, " + user.getName() + " " + user.getLastName() +"!");
		modelAndView.setViewName("homeBooks");	
		
		setSession(user, session); 
		
		//Larissa - Chamada do histórico passando e-mail do usuário 
		accessHistory.historyLog(user.getEmail());
		
		return modelAndView;

	}

	public void setSession(User user, HttpSession session) {

		//Larissa - Setando dados de usuário na Session
		session.setAttribute("id", user.getId());
		session.setAttribute("name", user.getName());
		session.setAttribute("lastName", user.getLastName());
		session.setAttribute("email", user.getEmail());
		session.setAttribute("cpf", user.getCpf());
		session.setAttribute("zipcode", user.getZipcode());
		session.setAttribute("state", user.getState());
		session.setAttribute("city", user.getCity());
		session.setAttribute("neighborhood", user.getNeighborhood());
		session.setAttribute("address", user.getAddress());
		session.setAttribute("complement", user.getComplement());
		session.setAttribute("number", user.getNumber());
		session.setAttribute("readlike", user.getReadlike());	
	}
	
}