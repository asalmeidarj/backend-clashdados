package com.clashdados.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.clashdados.models.Card;
import com.clashdados.repositories.CardRepository;


@Service
public class CardService {
	
	final CardRepository cardRepository;
	
	public CardService(CardRepository cardRepository) {
		this.cardRepository = cardRepository;		
	}
	
	public Card cadastrarCard(Card card) {
		card.setRegistro_card(LocalDateTime.now());
		return cardRepository.save(card);
	}
	
	public List<Card> buscarTodos(){
		return cardRepository.findAll();
	}
	
	public Card buscarPorId(Integer id_card) {
		Optional<Card> card = cardRepository.findById(id_card);
		return card.orElseThrow();
	}
}
