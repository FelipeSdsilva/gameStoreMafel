package com.storegame.mafil.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.storegame.mafil.dto.GenreDTO;
import com.storegame.mafil.entities.Genre;
import com.storegame.mafil.repositories.GenreRepository;

@Service
public class GenreService {

	@Autowired
	private GenreRepository genRepository;
	
	@Transactional(readOnly = true)
	public List<GenreDTO> findAllGenre(){
		List<Genre> listGen = genRepository.findAll();
		return listGen.stream().map(gen -> new GenreDTO(gen)).toList();
	}

}
