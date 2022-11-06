package com.storegame.mafil.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.storegame.mafil.entities.Platform;

@Repository
public interface PlatformRepository extends JpaRepository<Platform, Long>{

}
