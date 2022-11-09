package com.storegame.mafil.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.storegame.mafil.dto.GameDTO;
import com.storegame.mafil.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameResource {

	@Autowired
	private GameService gameService;

	@GetMapping
	public ResponseEntity<Page<GameDTO>> findPaged(Pageable pageable) {
		Page<GameDTO> gamePaged = gameService.findAllPaged(pageable);
		return ResponseEntity.ok().body(gamePaged);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<GameDTO> findById(@PathVariable Long id) {
		GameDTO gameDto = gameService.findById(id);
		return ResponseEntity.ok().body(gameDto);
	}

	@PostMapping
	public ResponseEntity<GameDTO> updateGame(@RequestBody GameDTO gameDto) {
		gameDto = gameService.insertNewGame(gameDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(gameDto.getId()).toUri();
		return ResponseEntity.created(uri).body(gameDto);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<GameDTO> updateGame(@PathVariable Long id, @RequestBody GameDTO gameDto) {
		gameDto = gameService.updateGame(id, gameDto);
		return ResponseEntity.ok().body(gameDto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteGame(@PathVariable Long id) {
		gameService.deleteGame(id);
		return ResponseEntity.noContent().build();
	}
}
