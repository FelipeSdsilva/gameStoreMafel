package com.storegame.mafil.dto;

import java.io.Serializable;
import java.time.Instant;

import com.storegame.mafil.entities.Game;

public class GameDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String title;
	private String description;
	private Double price;
	private String image;
	private String linkVideo;
	private Integer qtdStok;
	private Double metacritNote;
	private Instant dateLanc;

	public GameDTO() {
	}

	public GameDTO(Long id, String title, String description, Double price, String image, String linkVideo,
			Integer qtdStok, Double metacritNote, Instant dateLanc) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.image = image;
		this.linkVideo = linkVideo;
		this.qtdStok = qtdStok;
		this.metacritNote = metacritNote;
		this.dateLanc = dateLanc;
	}

	public GameDTO(Game entity) {
		id = entity.getId();
		title = entity.getTitle();
		description = entity.getDescription();
		price = entity.getPrice();
		image = entity.getImage();
		linkVideo = entity.getLinkVideo();
		qtdStok = entity.getQtdStok();
		metacritNote = entity.getMetacritcNote();
		dateLanc = entity.getDateLanc();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLinkVideo() {
		return linkVideo;
	}

	public void setLinkVideo(String linkVideo) {
		this.linkVideo = linkVideo;
	}

	public Integer getQtdStok() {
		return qtdStok;
	}

	public void setQtdStok(Integer qtdStok) {
		this.qtdStok = qtdStok;
	}

	public Double getMetacritNote() {
		return metacritNote;
	}

	public void setMetacritNote(Double metacritNote) {
		this.metacritNote = metacritNote;
	}

	public Instant getDateLanc() {
		return dateLanc;
	}

	public void setDateLanc(Instant dateLanc) {
		this.dateLanc = dateLanc;
	}
}
