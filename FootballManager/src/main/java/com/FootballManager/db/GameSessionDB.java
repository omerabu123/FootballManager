package com.FootballManager.db;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.FootballManager.beans.GameSession;

@Repository
public class GameSessionDB {

	@Autowired
	private GameSessionRepository repo;
	
	public void addGameSession(GameSession gameSession) {
		repo.save(gameSession);
	}
	
	public void updateGameSession(GameSession gameSession) {
		repo.save(gameSession);
	}

	public GameSession getOneSession(long gameSessionID) {
		Optional<GameSession> opt=repo.findById(gameSessionID);
		if (opt.isPresent())
			return opt.get();
		return null;
	}
	
}
