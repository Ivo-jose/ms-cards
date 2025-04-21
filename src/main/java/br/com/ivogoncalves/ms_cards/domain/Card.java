package br.com.ivogoncalves.ms_cards.domain;

import java.math.BigDecimal;

import br.com.ivogoncalves.ms_cards.domain.enums.CardFlag;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cards")
@Data
@NoArgsConstructor
public class Card {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;
	@Column
	private CardFlag flag;
	@Column
	private BigDecimal income;
	@Column(name = "basicLimit")
	private BigDecimal limit;
	
	
	public Card(String name, CardFlag flag, BigDecimal income, BigDecimal limit) {
		this.name = name;
		this.flag = flag;
		this.income = income;
		this.limit = limit;
	}
}
