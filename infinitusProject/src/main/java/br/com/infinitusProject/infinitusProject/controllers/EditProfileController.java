package br.com.infinitusProject.infinitusProject.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.infinitusProject.infinitusProject.models.User;
import br.com.infinitusProject.infinitusProject.services.UserService;

@Controller
public class EditProfileController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/editProfile", method = RequestMethod.GET)
	public ModelAndView editProfile() {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("editProfile");
		return modelAndView;				
	}

	@RequestMapping(value = "/editProfile", method = RequestMethod.POST)
	public ModelAndView editUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("entrou aq");
		if (bindingResult.hasErrors()) {
			System.out.println("entrou no binding");
			modelAndView.setViewName("editProfile");
			System.out.println("saiuu");
		} else {
			System.out.println("alterou aq");
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "Usuário atualizado com sucesso!");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("editProfile");
		}		
		System.out.println("saiu");
		return modelAndView;
	}
}
