package com.storegame.mafil.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.storegame.mafil.dto.GameDTO;
import com.storegame.mafil.entities.Game;
import com.storegame.mafil.repositories.GameRepository;
import com.storegame.mafil.services.exceptions.DatabaseException;
import com.storegame.mafil.services.exceptions.ResourceNotFoundException;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;

	@Transactional(readOnly = true)
	public Page<GameDTO> findAllPaged(Pageable pageable) {
		Page<Game> listGame = gameRepository.findAll(pageable);
		return listGame.map(game -> new GameDTO(game));
	}

	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game entity = gameRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new GameDTO(entity);
	}

	@Transactional
	public GameDTO insertNewGame(GameDTO gameDto) {
		Game entity = new Game();
		convertEntityForDto(gameDto, entity);
		entity = gameRepository.save(entity);
		return new GameDTO(entity);
	}

	@Transactional
	public GameDTO updateGame(Long id, GameDTO gameDto) {
		try {
			Game entity = gameRepository.getReferenceById(id);
			convertEntityForDto(gameDto, entity);
			entity = gameRepository.save(entity);
			return new GameDTO(entity);

		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}

	}

	public void deleteGame(Long id) {
		try {
			gameRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		} catch (EntityNotFoundException e) {
			throw new DatabaseException("Integrity violation ");
		}
	}

	private void convertEntityForDto(GameDTO gameDto, Game entity) {
		entity.setTitle(gameDto.getTitle());
		entity.setDescription(gameDto.getDescription());
		entity.setPrice(gameDto.getPrice());
		entity.setImage(gameDto.getImage());
		entity.setLinkVideo(gameDto.getLinkVideo());
		entity.setQtdStok(gameDto.getQtdStok());
		entity.setMetacriticNote(gameDto.getMetacriticNote());
		entity.setDateLanc(gameDto.getDateLanc());

	}
}
