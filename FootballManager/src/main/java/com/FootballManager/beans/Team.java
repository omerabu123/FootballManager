package com.FootballManager.beans;

import java.util.List;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Team implements Comparable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long teamID;
	@ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	private List<Player> teamPlayers;
	@Column
	private String teamName;
	@Column
	private double teamRating;
	public Team() {}

	public Team(long teamID, List<Player> teamPlayers, String teamName) {
		super();
		this.teamID = teamID;
		this.teamPlayers = teamPlayers;
		this.teamName = teamName;
	}
	
	public Team(char teamName, List<Player> teamPlayers) {
		super();
		this.teamName =String.valueOf(teamName);
		this.teamPlayers = teamPlayers;
	}

	public List<Player> getTeamPlayers() {
		return teamPlayers;
	}

	public void setTeamPlayers(List<Player> teamPlayers) {
		this.teamPlayers = teamPlayers;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public long getTeamID() {
		return teamID;
	}
	
	public double getTeamRating() {
		return teamRating;
	}

	public void setTeamRating(double teamRating) {
		this.teamRating = teamRating;
	}

	@Override
	public boolean equals(Object obj) {
		Team team=(Team) obj;
		if (team.getTeamName().equals(this.teamName))
			return true;
		else
			return false;
	}
	
	@Override
	public int compareTo(Object o) {
		Team teamToCompare=(Team) o;
		if (teamRating>teamToCompare.getTeamRating())
			return -1;
		if (teamRating==teamToCompare.getTeamRating()){
			Random rnd=new Random();
			int random=rnd.nextInt(2);
			if (random==1)
			return 1;
			else 
			return -1;
		}
		else
		return 1;
	}
	
	public void updateTeamRating() {
		for (Player player : teamPlayers) {
			this.teamRating+=player.getPlayerRating();
		}
	}
	
	public void addPlayerToTeam(Player player) {
		this.teamPlayers.add(player);
		this.teamRating+=player.getPlayerRating();
	}

	@Override
	public String toString() {
		return "Team [teamName=" + teamName + ", teamPlayers=" + teamPlayers + ", teamRating=" + teamRating + "]";
	}
	
}
