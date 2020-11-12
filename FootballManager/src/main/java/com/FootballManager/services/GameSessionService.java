package com.FootballManager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FootballManager.beans.GameSession;
import com.FootballManager.db.GameSessionDB;
import com.FootballManager.exceptions.CannotFindEntity;

@Service
public class GameSessionService {

	@Autowired
	private GameSessionDB gameSessionDB;
	
	public GameSession getOneGameSession(long gameSessionID) throws CannotFindEntity {
		if (gameSessionDB.getOneSession(gameSessionID)==null)
			throw new CannotFindEntity("Game session not found");
		return gameSessionDB.getOneSession(gameSessionID);
	}
}
