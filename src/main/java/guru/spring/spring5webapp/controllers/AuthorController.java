package guru.spring.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.spring.spring5webapp.repositories.AuthorRepository;


@Controller
public class AuthorController {

	private AuthorRepository authRepo;


	public AuthorController(AuthorRepository authRepo) {
		super();
		this.authRepo = authRepo;
	}

	@RequestMapping("/authors")
	public String getAuthors(Model model) {
		model.addAttribute("authors", authRepo.findAll());
		return "authors/list";
	}
	
}
