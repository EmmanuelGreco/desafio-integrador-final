package com.educacionit.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.educacionit.entity.Role;
import com.educacionit.repository.RoleRepository;

@Component
@Configuration
public class RoleDataInitializer {

	@Bean
	public CommandLineRunner loadRolesData(RoleRepository roleRepository) {
		return args -> {
			String[] roles = { "ADMIN", "SOCIO" };
			for (String roleName : roles) {
				if (!roleRepository.findByName(roleName).isPresent()) {
					Role role = new Role();
					role.setName(roleName);
					roleRepository.save(role);
				}
			}
		};
	}
}
