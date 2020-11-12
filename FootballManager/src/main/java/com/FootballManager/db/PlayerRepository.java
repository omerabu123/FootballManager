package com.FootballManager.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FootballManager.beans.Player;

public interface PlayerRepository extends JpaRepository<Player, Long>{

	
}
