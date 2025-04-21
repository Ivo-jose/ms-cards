package br.com.ivogoncalves.ms_cards.infra.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ivogoncalves.ms_cards.domain.CustomerCard;

@Repository
public interface CustomerCardsRepository extends JpaRepository<CustomerCard, Long>{
	List<CustomerCard> findByCpf(String cpf);
}
