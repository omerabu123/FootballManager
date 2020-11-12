package com.FootballManager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FootballManager.beans.Player;
import com.FootballManager.db.PlayerDB;
import com.FootballManager.exceptions.CannotFindEntity;
import com.FootballManager.exceptions.PlayerExists;
import com.FootballManager.exceptions.PlayerNotExists;


@Service
public class PlayerService {

	 @Autowired
	 private PlayerDB playerDB;
	 
	 public void addPlayer(Player player) throws PlayerExists {
		 if (playerDB.getPlayerById(player.getPlayerID())!=null)
			 throw new PlayerExists();
		 else
		 playerDB.addPlayer(player);
	 }
	 
	 public void deletePlayer(long id) {
		 playerDB.deleteById(id);
	 }
	 
	 public Player getOnePlayer(long id) throws CannotFindEntity {
		 if (playerDB.getPlayerById(id)==null)
			 throw new CannotFindEntity("player not exists");
		 return playerDB.getPlayerById(id);
	 }

	public void changePlayerRating(long playerID, double rating) {
		Player player=playerDB.getPlayerById(playerID);
		player.setPlayerRating(rating);
		playerDB.updatePlayer(player);
	}
	 
	 
}
