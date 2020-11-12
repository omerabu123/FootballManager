package com.FootballManager.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FootballManager.beans.GameSession;

public interface GameSessionRepository extends JpaRepository<GameSession, Long>{

}
