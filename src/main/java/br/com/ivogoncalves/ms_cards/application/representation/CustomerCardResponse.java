package br.com.ivogoncalves.ms_cards.application.representation;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.ivogoncalves.ms_cards.domain.CustomerCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerCardResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	private String flag;
	private BigDecimal limitReleased;
	
	public static CustomerCardResponse fromModel(CustomerCard model) {
		return new CustomerCardResponse(model.getId(), model.getCard().getFlag().toString(), model.getLimit());
	}
}
