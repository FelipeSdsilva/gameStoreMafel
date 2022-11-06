package com.storegame.mafil.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.storegame.mafil.dto.GameDTO;
import com.storegame.mafil.entities.Game;
import com.storegame.mafil.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public Page<GameDTO> findAllPaged(Pageable pageable){
		Page<Game> listGame = gameRepository.findAll(pageable);
		return listGame.map(game -> new GameDTO(game));
	}
}
