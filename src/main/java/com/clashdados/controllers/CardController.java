package com.clashdados.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.clashdados.models.Attachment;
import com.clashdados.models.Card;
import com.clashdados.services.AttachmentService;
import com.clashdados.services.CardService;


@CrossOrigin
@RestController
@RequestMapping("/clash-dados")
public class CardController {
	
	final CardService cardService;
	final AttachmentService attachmentService;
	
	public CardController(CardService cardService, AttachmentService attachmentService) {
		this.cardService = cardService;
		this.attachmentService = attachmentService;
	}
	/* As linhas acima podem ser substituídas por:
	 * 
	 *  @Autowired
	 *  private CardService cardService;
	 *  
	 */
	
	@PostMapping("/cadastrar-cards")
	public ResponseEntity<Card> cadastrarCard(
			@RequestParam("file")MultipartFile file, 
			@RequestParam String nome, 
			@RequestParam String raridade, 
			@RequestParam String tipo, 
			@RequestParam String descricao) throws Exception{
		
		Attachment attachment = null;
        String downloadURl = "";
        attachment = attachmentService.saveAttachment(file);
        downloadURl = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(attachment.getId())
                .toUriString();
        
        Card card = new Card();
        card.setNome_card(nome);
        card.setRaridade_card(raridade);
        card.setTipo_card(tipo);
        card.setDescricao_card(descricao);
        card.setId_imagem(attachment.getId());
        card.setUrl_imagem(downloadURl);
        Card data = cardService.cadastrarCard(card);
		/*return ResponseEntity.noContent().build();*/	
		
		return ResponseEntity.ok().body(data);
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
