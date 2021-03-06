package br.com.infinitusProject.infinitusProject.controllers;

import javax.servlet.http.HttpSession;
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

	//Larissa - Request GET para exibição da página de Editar Perfil
	@RequestMapping(value = "/editProfile", method = RequestMethod.GET)
	public ModelAndView editProfile() {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("editProfile"); 
				
		return modelAndView;				
		}
	
	//Larissa - Request POST para validação de dados vindos da página
	@RequestMapping(value = "/editProfile", method = RequestMethod.POST)
	public ModelAndView editUser(@Valid User user, BindingResult bindingResult, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("editProfile");
		} else {
			user.setEmail((String)session.getAttribute("email"));
			userService.updateUser(user);
			modelAndView.addObject("successMessage", "Usuário atualizado com sucesso!");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("editProfile");
			
			LoginController loginController = new LoginController();
			loginController.setSession(user, session);
		}		
		
				
		return modelAndView;
	}
	
}
