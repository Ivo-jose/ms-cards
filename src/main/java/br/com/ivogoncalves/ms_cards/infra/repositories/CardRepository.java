package br.com.ivogoncalves.ms_cards.infra.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ivogoncalves.ms_cards.domain.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long>{

	List<Card> findByIncomeLessThanEqual(BigDecimal income);	
}
