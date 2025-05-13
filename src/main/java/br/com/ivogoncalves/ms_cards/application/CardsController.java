package br.com.ivogoncalves.ms_cards.application;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ivogoncalves.ms_cards.application.representation.CardSaveRequest;
import br.com.ivogoncalves.ms_cards.application.representation.CustomerCardResponse;
import br.com.ivogoncalves.ms_cards.domain.Card;
import br.com.ivogoncalves.ms_cards.domain.CustomerCard;

@RestController
@RequestMapping("/api/cards")
public class CardsController {
	
	@Autowired
	private CardService cardService;
	
	@Autowired
	private CustomerCardService customerCardService;

	@GetMapping
	public String getStatus() {
		return "Service Card: OK!!";
	}
	
	@GetMapping(params = "income")
	public ResponseEntity<List<CardSaveRequest>> getAllCardsWithIncomeLessThanEqual(@RequestParam BigDecimal income) {
		List<Card> entities = cardService.getLessThanOrEqualIncome(income);
		List<CardSaveRequest> dtos = entities.stream().map(e -> 
							new CardSaveRequest(e.getId(), e.getName(), e.getFlag(), e.getIncome(), e.getBasicLimit()))
												.collect(Collectors.toList());
		return  ResponseEntity.ok().body(dtos);
	}
	
	@GetMapping(params = "cpf")
	public ResponseEntity<List<CustomerCardResponse>> getCardsByCustomer(@RequestParam String cpf) {
		 List<CustomerCard> entities = customerCardService.cardsListByCpf(cpf);
		 var dtos = entities.stream().map(CustomerCardResponse::fromModel).collect(Collectors.toList());
		return ResponseEntity.ok().body(dtos);
	}
	
	
	@PostMapping
	public ResponseEntity<CardSaveRequest> saveCard(@RequestBody CardSaveRequest request) {
		var entity  = request.toModel();
		var persisted = cardService.save(entity) ;
		URI headerLocation = ServletUriComponentsBuilder.fromCurrentRequest()
								.queryParam("id",persisted.getId())
								.build()
								.toUri();
		return ResponseEntity.created(headerLocation).body(
					new CardSaveRequest(persisted.getId(), persisted.getName(), persisted.getFlag(), 
														persisted.getIncome(), persisted.getBasicLimit()));
	}	
}
