package com.FootballManager.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FootballManager.beans.Player;
import com.FootballManager.beans.PlayerRole;
import com.FootballManager.beans.Team;
import com.FootballManager.db.PlayerDB;
import com.FootballManager.db.TeamDB;
import com.FootballManager.exceptions.CannotFindEntity;

@Service
public class TeamService {

	@Autowired
	private TeamDB teamDB;
	@Autowired
	private PlayerDB playerDB;
	private long teamID;
	 
	public Team getOneTeam(long teamID) throws CannotFindEntity {
		if (teamDB.getTeamById(teamID)==null)
			throw new CannotFindEntity("team cannot be found!");
		return teamDB.getTeamById(teamID);
	}
}
