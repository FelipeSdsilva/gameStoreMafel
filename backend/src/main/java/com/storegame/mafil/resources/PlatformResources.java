package com.storegame.mafil.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.storegame.mafil.dto.PlatformDTO;
import com.storegame.mafil.services.PlatformService;

@RestController
@RequestMapping(value = "/platforms")
public class PlatformResources {

	@Autowired
	private PlatformService platfService;

	@GetMapping
	public ResponseEntity<List<PlatformDTO>> findAll(){
		List<PlatformDTO> listPlat = platfService.findAllPlat();
		return ResponseEntity.ok().body(listPlat);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PlatformDTO> findById(@PathVariable Long id){
		PlatformDTO platDto = platfService.findById(id);
		return ResponseEntity.ok().body(platDto);
	}
	
	@PostMapping
	public ResponseEntity<PlatformDTO> insertNewPlat(@RequestBody PlatformDTO platDto){
		platDto = platfService.insertPlat(platDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(platDto.getId()).toUri();
		return ResponseEntity.created(uri).body(platDto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<PlatformDTO> updadePlat(@PathVariable Long id,@RequestBody PlatformDTO platDto){
		platDto = platfService.updatePlat(id,platDto);
		return ResponseEntity.ok().body(platDto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletePlat(@PathVariable Long id){
		platfService.deletePlatform(id);
		return ResponseEntity.noContent().build();
	}
}
