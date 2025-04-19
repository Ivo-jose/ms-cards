package br.com.ivogoncalves.application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cards")
public class CardsController {

	@GetMapping
	public String getStatus() {
		return "Service Card: OK!!";
	}
}
