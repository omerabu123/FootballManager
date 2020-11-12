package com.FootballManager.db;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.FootballManager.beans.Player;

@Repository
public class PlayerDB {

	@Autowired
	private PlayerRepository repo;
	
	public void addPlayer(Player player) {
		repo.save(player);
	}
	
	public Player getPlayerById(long id) {
		Optional<Player> opt=repo.findById(id);
		if (opt.isPresent())
			return opt.get();
		return null;
	}

	public void deleteById(long id) {
		repo.deleteById(id);
	}

	public void updatePlayer(Player player) {
		repo.save(player);
	}
}
