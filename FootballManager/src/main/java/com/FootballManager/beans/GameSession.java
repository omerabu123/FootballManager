package com.FootballManager.beans;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class GameSession {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long gameSessionID;
	@Column
	private int numberOfTeams;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Team> sessionTeams;
//	@Column
//	private Date sessionDate;

	public GameSession() {}

	
	public GameSession(long gameSessionID, int numberOfTeams) {
		super();
		this.gameSessionID = gameSessionID;
		this.numberOfTeams = numberOfTeams;
	}


	/*Date sessionDate*/
	public GameSession(int numberOfTeams, List<Team> sessionTeams) {
		super();
		this.numberOfTeams = numberOfTeams;
		this.sessionTeams = sessionTeams;
//		this.sessionDate=sessionDate;
	}


	public GameSession(long gameSessionID, int numberOfTeams, List<Team> sessionTeams) {
		super();
		this.gameSessionID = gameSessionID;
		this.numberOfTeams = numberOfTeams;
		this.sessionTeams = sessionTeams;
	}


	public int getNumberOfTeams() {
		return numberOfTeams;
	}

	public void setNumberOfTeams(int numberOfTeams) {
		this.numberOfTeams = numberOfTeams;
	}

	public List<Team> getSessionPlayers() {
		return sessionTeams;
	}

	public void setSessionPlayers(List<Team> sessionTeams) {
		this.sessionTeams = sessionTeams;
	}

	public long getGameSessionID() {
		return gameSessionID;
	}
	
//	public void setSessionDate(Date sessionDate) {
//		this.sessionDate=sessionDate;
//	}
//	public Date getSessionDate() {
//		return sessionDate;
//	}


	@Override
	public String toString() {
		return "GameSession [gameSessionID=" + gameSessionID + ", numberOfTeams=" + numberOfTeams + ", sessionTeams="
				+ sessionTeams + "]";
	}
	
	
}
