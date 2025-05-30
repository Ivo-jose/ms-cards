package br.com.ivogoncalves.ms_cards.application.representation;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.ivogoncalves.ms_cards.domain.CustomerCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class CustomerCardResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String flag;
	private BigDecimal limitReleased;
	
	public static CustomerCardResponse fromModel(CustomerCard model) {
		log.info("Converting CustomerCard model to CustomerCardResponse: {}", model);
		return new CustomerCardResponse(model.getId(),model.getCard().getName() ,model.getCard().getFlag().toString(), model.getLimitReleased().setScale(2));
	}
}
