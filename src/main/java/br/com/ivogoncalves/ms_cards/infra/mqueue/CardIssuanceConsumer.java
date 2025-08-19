package br.com.ivogoncalves.ms_cards.infra.mqueue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.ivogoncalves.ms_cards.application.CardService;
import br.com.ivogoncalves.ms_cards.application.CustomerCardService;
import br.com.ivogoncalves.ms_cards.domain.CardIssuanceRequestData;
import br.com.ivogoncalves.ms_cards.domain.CustomerCard;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class CardIssuanceConsumer {
	
	private final CardService cardService;
	private final CustomerCardService customerCardService;

	@RabbitListener(queues = "${mq.queues.card-issuance}")
	public void receiveIssuanceRequest(@Payload String payload) {
	    try {
	    	var mapper = new ObjectMapper();
			CardIssuanceRequestData data = mapper.readValue(payload, CardIssuanceRequestData.class);
			log.info("Received card issuance request: {}", data);
			var card = cardService.getCard(data.getIdCard());
			CustomerCard customer = new CustomerCard();
			customer.setCpf(data.getCpf());
			customer.setCard(card);
			customer.setLimitReleased(data.getReleasedLimit());
			customerCardService.save(customer);
		} catch (Exception e) {
			log.error("Error processing card issuance request: {}", e.getMessage());
		}
			
	}
}
