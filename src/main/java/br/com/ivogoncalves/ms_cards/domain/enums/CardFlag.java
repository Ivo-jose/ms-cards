package br.com.ivogoncalves.ms_cards.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CardFlag {
	
	MASTERCARD(0, "master card"), VISA(1, "visa");
	
	private final int code;
	private final String description;
	
	public static CardFlag toEnum(Integer cod) {
		if(cod == null) return null;
		for(CardFlag cf: CardFlag.values()) {
			if(cod.equals(cf.getCode())) return cf;
		}
		throw new IllegalArgumentException("Invalid Flag Code! + CODE: " + cod);
	}
}
