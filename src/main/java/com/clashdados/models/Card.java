package com.clashdados.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Card implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id_card;
	
	@Column(nullable=false, length=30)
	private String nome_card;
	
	@Column(nullable=false, length=16)
	private String raridade_card;
	
	@Column(nullable=false, length=16)
	private String tipo_card;
	
	@Column(nullable=false, length=250)
	private String descricao_card;
	
	@Column(nullable=false, length=120)
	private String id_imagem;
	
	@Column(nullable=false, length=120)
	private String url_imagem;
	
	@Column(nullable=false)
	private LocalDateTime registro_card;
}
