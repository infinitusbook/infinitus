package br.com.infinitusProject.infinitusProject.services;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.infinitusProject.infinitusProject.models.*;
import br.com.infinitusProject.infinitusProject.repositories.*;

@Service("userService")
public class UserService {

    // Larissa - Classe que implementa os métodos instânciados a partir 
	// do Repositório que utiliza a biblioteca JPA 
	
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }
    
    public void updateUser(User user) {    	
    	User userUpdate = userRepository.findByEmail(user.getEmail());
    	userUpdate.setZipcode(user.getZipcode());
    	userUpdate.setAddress(user.getAddress());
    	userUpdate.setState(user.getState());
    	userUpdate.setCity(user.getCity());
    	userUpdate.setNeighborhood(user.getNeighborhood());
    	userUpdate.setReadlike(user.getReadlike());   
    	userUpdate.setCpf(user.getCpf());
    	userUpdate.setNumber(user.getNumber());
    	userUpdate.setComplement(user.getComplement());
    	
    	if(!user.getPassword().isEmpty()){
    		userUpdate.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    	}
    	
    	userRepository.save(userUpdate);
    }
  
            
}