package com.FootballManager.db;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.FootballManager.beans.Team;

@Repository
public class TeamDB {

	@Autowired
	private TeamRepository repo;
	
	public void addTeam(Team team) {
		repo.save(team);
	}
	
	public Team getTeamById(long id) {
		Optional<Team> opt=repo.findById(id);
		if (opt.isPresent())
			return opt.get();
		return null;
	}

	public void update(Team team) {
		repo.save(team);
	}
}
