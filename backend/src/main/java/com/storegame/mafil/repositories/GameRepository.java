package com.storegame.mafil.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.storegame.mafil.entities.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

}
