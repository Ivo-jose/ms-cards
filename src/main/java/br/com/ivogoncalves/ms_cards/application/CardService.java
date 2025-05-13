package br.com.ivogoncalves.ms_cards.application;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ivogoncalves.ms_cards.domain.Card;
import br.com.ivogoncalves.ms_cards.domain.exceptions.ObjectNotNull;
import br.com.ivogoncalves.ms_cards.domain.exceptions.ResourceNotFoundException;
import br.com.ivogoncalves.ms_cards.infra.repositories.CardRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CardService {

	@Autowired
	private CardRepository cardRepository;
	
	public Card getCard(Long id) {
		log.info("Find card by Id! ID: " + id);
		return cardRepository.findById(id).orElseThrow(() ->
									new ResourceNotFoundException("Resource not found! ID: " + id));
	}
	
	public List<Card> getLessThanOrEqualIncome(BigDecimal value) {
		log.info("Find all cards income less than or equal to {}", value);
		return cardRepository.findByIncomeLessThanEqual(value);
	}
	
	@Transactional
	public Card save(Card card) {
		log.info("Saving a new card {}", card);
		if(card == null) throw new ObjectNotNull("Don't persist null objects!");
		return cardRepository.save(card);
	}
}
