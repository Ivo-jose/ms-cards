package br.com.ivogoncalves.ms_cards.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ivogoncalves.ms_cards.domain.CustomerCard;
import br.com.ivogoncalves.ms_cards.domain.exceptions.AttributeValidationException;
import br.com.ivogoncalves.ms_cards.domain.exceptions.ObjectNotNull;
import br.com.ivogoncalves.ms_cards.infra.repositories.CustomerCardsRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerCardService {

	@Autowired
	private CustomerCardsRepository customerCardRepository;
	
	public List<CustomerCard> cardsListByCpf(String cpf) {
		log.info("Listing customer cards by CPF");
		checkFormatCpf(cpf);
		return customerCardRepository.findByCpf(cpf);
	}
	
	public CustomerCard save(CustomerCard customerCard) {
		log.info("Saving a new customer card: {}", customerCard);
		if(customerCard == null) throw new ObjectNotNull("Don't persist null objects!");
		checkFormatCpf(customerCard.getCpf());
		return customerCardRepository.save(customerCard);
	}
	
	// Auxiliary method to check the format of the CPF
	private void checkFormatCpf(String cpf) {
		if(!cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}"))
			throw new AttributeValidationException("Invalid CPF format! Expected format: XXX.XXX.XXX-XX");
	}
}
