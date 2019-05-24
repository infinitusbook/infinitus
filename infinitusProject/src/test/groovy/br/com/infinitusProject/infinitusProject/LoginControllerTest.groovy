package br.com.infinitusProject.infinitusProject

import org.springframework.data.domain.Page
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource
import br.com.infinitusProject.infinitusProject.controllers.LoginController
import br.com.infinitusProject.infinitusProject.models.User
import br.com.infinitusProject.infinitusProject.services.UserService
import com.nimbusds.oauth2.sdk.http.HTTPResponse
import javax.servlet.http.HttpServletRequest
import net.bytebuddy.asm.Advice.This
import spock.lang.Specification

class LoginControllerTest extends Specification{		
	
	/*
	def 'deve retornar /login' () {		
			given:
			//def urlBase = 'http://localhost:8080/admin/home'
			def loginController = new LoginController()
			HttpServletRequest request = Mock()
			def user = Mock(User);
			user.getEmail() >> "teste1@teste.com"
			user.getPassword() >> "testeteste"					
									
			when:
			def retorno = loginController.
			
			//then:	
			//retorno == "redirect:/homeUser"
			
	}
}*/
	
}
