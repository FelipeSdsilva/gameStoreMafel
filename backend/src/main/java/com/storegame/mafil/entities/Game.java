package com.storegame.mafil.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "tb_game")
public class Game implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;

	@Column(columnDefinition = "TEXT")
	private String description;
	private Double price;
	private String image;
	private String linkVideo;
	private Integer qtdStok;
	private Double metacriticNote;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dateLanc;
	
	@ManyToMany
	@JoinTable(name = "tb_game_genre",
			joinColumns = @JoinColumn(name = "game_id"),
			inverseJoinColumns = @JoinColumn(name = "genre_id"))
	private Set<Genre> genres = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name = "tb_game_platform",
			joinColumns = @JoinColumn(name = "game_id"),
			inverseJoinColumns = @JoinColumn(name = "platform_id"))
	private Set<Platform> platforms = new HashSet<>();
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant createAt;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant updateAt;
	
	
	public Game() {
	}

	public Game(Long id, String title, String description, Double price, String image, String linkVideo,
			Integer qtdStok, Double metacriticNote, Instant dateLanc) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.image = image;
		this.linkVideo = linkVideo;
		this.qtdStok = qtdStok;
		this.metacriticNote = metacriticNote;
		this.dateLanc = dateLanc;
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

	public Double getMetacriticNote() {
		return metacriticNote;
	}

	public void setMetacriticNote(Double metacriticNote) {
		this.metacriticNote = metacriticNote;
	}

	public Instant getDateLanc() {
		return dateLanc;
	}

	public void setDateLanc(Instant dateLanc) {
		this.dateLanc = dateLanc;
	}

	public Set<Genre> getGenres() {
		return genres;
	}

	public Set<Platform> getPlatforms() {
		return platforms;
	}	

	public Instant getCreateAt() {
		return createAt;
	}

	public Instant getUpdateAt() {
		return updateAt;
	}

	@PrePersist
	public void prePersist() {
		createAt = Instant.now();
	}
	
	@PreUpdate
	public void preUpdate() {
		updateAt = Instant.now();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		return Objects.equals(id, other.id);
	}
}
