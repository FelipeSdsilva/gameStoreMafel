package com.storegame.mafil.dto;

import java.io.Serializable;

import com.storegame.mafil.entities.Platform;

public class PlatformDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;

	public PlatformDTO() {
	}

	public PlatformDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public PlatformDTO(Platform entity) {
		id = entity.getId();
		name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
