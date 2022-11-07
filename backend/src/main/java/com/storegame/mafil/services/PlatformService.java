package com.storegame.mafil.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.storegame.mafil.dto.PlatformDTO;
import com.storegame.mafil.entities.Platform;
import com.storegame.mafil.repositories.PlatformRepository;
import com.storegame.mafil.services.exceptions.DatabaseException;
import com.storegame.mafil.services.exceptions.ResourceNotFoundException;

@Service
public class PlatformService {

	@Autowired
	private PlatformRepository platRepository;

	@Transactional(readOnly = true)
	public List<PlatformDTO> findAllPlat() {
		List<Platform> listPlat = platRepository.findAll();
		return listPlat.stream().map(plat -> new PlatformDTO(plat)).toList();
	}

	@Transactional(readOnly = true)
	public PlatformDTO findById(Long id) {
		Platform entity = platRepository.getReferenceById(id);
		return new PlatformDTO(entity);
	}

	@Transactional
	public PlatformDTO insertPlat(PlatformDTO platDto) {
		Platform entity = new Platform();
		entity.setName(platDto.getName());
		entity = platRepository.save(entity);
		return new PlatformDTO(entity);
	}

	@Transactional
	public PlatformDTO updatePlat(Long id, PlatformDTO platDto) {
		try {
			Platform entity = platRepository.getReferenceById(id);
			entity.setName(platDto.getName());
			entity = platRepository.save(entity);
			return new PlatformDTO(entity);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}

	}

	public void deletePlatform(Long id) {
		try {
			platRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		} catch (EntityNotFoundException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
}
