package br.com.ivogoncalves.ms_cards.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AttributeValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AttributeValidationException(String message) {
		super(message);
	}
}
