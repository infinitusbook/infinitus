package br.com.infinitusProject.infinitusProject

import javax.persistence.*

import br.com.infinitusProject.infinitusProject.models.User
import spock.lang.Specification
/*
class InfinitusProjectApplicationTest extends Specification {
	
	def 'toUpperCase deve deixar maiusculo'() {
		given:
		def entrada = 'fogo'
		
		when:
		def maiuscula = entrada.toUpperCase()
		
		then:
		maiuscula == 'FOGO'
	}
}*/

class InfinitusProjectApplicationTest extends Specification {
	
	
	def 'classe deve estar com o @Table'(){
		expect:
		User.getAnnotation(Table)
	}
}


