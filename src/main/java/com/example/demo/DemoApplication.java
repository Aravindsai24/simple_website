package com.example.demo;

import com.example.demo.models.Url;
import com.example.demo.models.User;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@Controller
public class DemoApplication {
	@Autowired
	private UsersRepository usersRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/")
	public String entry() {
		return "entry";
	}

	@GetMapping("/register")
	public String getRegister(Model model) {
		User user = new User();
		model.addAttribute("user",user);
		return "preRegister";
	}

	@PostMapping("/register")
	public String postRegister(@ModelAttribute("user") User user) {
		User createdUser = usersRepository.save(user);
		System.out.println(createdUser.getUsername());
		return "postRegister";
	}

	@GetMapping("/login")
	public String getLogin(Model model) {
		User user = new User();
		model.addAttribute("user",user);
		return "preLogin";
	}

	@PostMapping("/login")
	public String postLogin(Model model, @ModelAttribute("user") User user) {
		List<User> userList = usersRepository.findAll();
		model.addAttribute("URL", new Url());
		for(Integer i=0;i<userList.size();i++) {
			if((userList.get(i).getUsername().equals( user.getUsername() )) && (userList.get(i).getPassword().equals(user.getPassword()))) {
				return "postSuccesfulLogin";
			}
		}
		return "preLogin";
	}

	@PostMapping("/open")
	public String openUrl(@ModelAttribute("URL") Url URL) {
		String myURL = URL.getMyUrl();
		System.out.println(myURL);
		return "redirect:" + myURL;
	}

}
