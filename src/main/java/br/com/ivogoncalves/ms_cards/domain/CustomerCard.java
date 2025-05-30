package br.com.ivogoncalves.ms_cards.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer_card")
@Data
@NoArgsConstructor
public class CustomerCard implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String cpf;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_card")
	private Card card;
	@Column(name = "limitReleased")
	private BigDecimal limitReleased;
}
