package br.com.ivogoncalves.ms_cards.application.representation;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.ivogoncalves.ms_cards.domain.Card;
import br.com.ivogoncalves.ms_cards.domain.enums.CardFlag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor	
@AllArgsConstructor
public class CardSaveRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private CardFlag flag;
	private BigDecimal income;
	private BigDecimal basicLimit;
	
	public Card toModel() {
		return new Card(name, flag, income, basicLimit);
	}
}
