package com.vedant.crud_demo;

import com.vedant.crud_demo.entity.Member;
import com.vedant.crud_demo.entity.Role;
import com.vedant.crud_demo.service.MemberService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;
@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner userCreation(MemberService memberService) {
		return args -> {
			Member user = new Member();
			user.setUserId("adi");
			user.setPassword("{noop}test123");
			user.setActive(1);

			Role role1 = new Role();
			role1.setRole("ROLE_EMPLOYEE");
			role1.setMember(user);

			Role role2 = new Role();
			role2.setRole("ROLE_MANAGER");
			role2.setMember(user);

//			Role role3 = new Role();
//			role3.setRole("ROLE_ADMIN");
//			role3.setMember(user);

			Set<Role> roles = new HashSet<>();
			roles.add(role1);
			roles.add(role2);
//			roles.add(role3);

			user.setRoles(roles);

			Member savedUser = memberService.createMember(user);

			System.out.println("✅ User created and saved:");
			System.out.println(savedUser);
		};
	}

}
