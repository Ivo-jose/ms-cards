package br.com.ivogoncalves.ms_cards.domain.exceptions;

public class ObjectNotNull extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ObjectNotNull(String message) {
		super(message);
	}
}
