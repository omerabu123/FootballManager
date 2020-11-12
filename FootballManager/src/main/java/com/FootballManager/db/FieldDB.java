package com.FootballManager.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.FootballManager.beans.Field;
import com.FootballManager.beans.Player;

@Repository
public class FieldDB {

	@Autowired
	private FieldRepository repo;
	
	public Field addField(Field field) {
		return repo.save(field);
	}
	
	public List<Player> getAllFieldPlayers(long fieldID){
		return getOneField(fieldID).getPlayerList();
	}

	public Field getOneField(long fieldID) {
		Optional<Field> opt=repo.findById(fieldID);
		if (opt.isPresent())
			return opt.get();
		return null;
	}
	
	public void updateField(Field field) {
		repo.save(field);
	}
}
