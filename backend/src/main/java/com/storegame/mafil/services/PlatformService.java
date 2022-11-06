package com.storegame.mafil.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.storegame.mafil.dto.PlatformDTO;
import com.storegame.mafil.entities.Platform;
import com.storegame.mafil.repositories.PlatformRepository;

@Service
public class PlatformService {

	@Autowired
	private PlatformRepository platRepository;	

	@Transactional(readOnly = true)
	public List<PlatformDTO> findAllPlat(){
		List<Platform> listPlat = platRepository.findAll();
		return listPlat.stream().map(plat -> new PlatformDTO(plat)).toList();
	}

}

