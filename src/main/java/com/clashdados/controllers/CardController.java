package com.clashdados.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clashdados.models.Card;
import com.clashdados.services.CardService;


@CrossOrigin
@RestController
@RequestMapping("/clash-dados")
public class CardController {
	
	final CardService cardService;
	
	public CardController(CardService cardService) {
		this.cardService = cardService;
	}
	/* As linhas acima podem ser substituídas por:
	 * 
	 *  @Autowired
	 *  private CardService cardService;
	 *  
	 */
	
	@PostMapping("/card")
	public ResponseEntity<Card> cadastrarCard(@RequestBody Card card){
		cardService.cadastrarCard(card);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/card")
	public List<Card> buscarTodos(){
		return cardService.buscarTodos();
	}
	
	@GetMapping("/card/{id_card}")
	public ResponseEntity<Card> buscarPorId(@PathVariable Integer id_card){
		Card card = cardService.buscarPorId(id_card);
		return ResponseEntity.ok().body(card);
	}
	
}
