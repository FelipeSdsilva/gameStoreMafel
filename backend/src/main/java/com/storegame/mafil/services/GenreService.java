package com.storegame.mafil.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.storegame.mafil.dto.GenreDTO;
import com.storegame.mafil.entities.Genre;
import com.storegame.mafil.repositories.GenreRepository;
import com.storegame.mafil.services.exceptions.DatabaseException;
import com.storegame.mafil.services.exceptions.ResourceNotFoundException;

@Service
public class GenreService {

	@Autowired
	private GenreRepository genRepository;

	@Transactional(readOnly = true)
	public List<GenreDTO> findAllGenre() {
		List<Genre> listGen = genRepository.findAll();
		return listGen.stream().map(gen -> new GenreDTO(gen)).toList();
	}

	@Transactional(readOnly = true)
	public GenreDTO findById(Long id) {
		Genre entity = genRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entity not Found "));
		return new GenreDTO(entity);

	}

	@Transactional
	public GenreDTO insertGenre(GenreDTO genreDto) {
		Genre entity = new Genre();
		entity.setName(genreDto.getName());
		entity = genRepository.save(entity);
		return new GenreDTO(entity);
	}

	@Transactional
	public GenreDTO updateGenre(Long id, GenreDTO genreDto) {
		Genre entity = genRepository.getReferenceById(id);
		entity.setName(genreDto.getName());
		entity = genRepository.save(entity);
		return new GenreDTO(entity);
	}

	public void deleteGenre(Long id) {
		try {
			genRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		} catch (EntityNotFoundException e) {
			throw new DatabaseException("Integrety violation");
		}
	}
}
