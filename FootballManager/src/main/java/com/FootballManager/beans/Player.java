package com.FootballManager.beans;

import java.util.List;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player implements Comparable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long playerID;
	@Column
	private String playerName;
	@Column
	private double playerRating;
	@Column
	private PlayerRole playerRole;
	@Column
	private String playerImage;
	@Column
	private boolean manager;
	
	public Player() {}

	public Player(long playerID, String playerName, double playerRating, PlayerRole playerRole, String playerImage,boolean manager) {
		super();
		this.playerID = playerID;
		this.playerName = playerName;
		this.playerRating = playerRating;
		this.playerRole = playerRole;
		this.playerImage = playerImage;
		this.manager=manager;
	}

	public Player(String playerName, double playerRating, PlayerRole playerRole, String playerImage,boolean manager) {
		super();
		this.playerName = playerName;
		this.playerRating = playerRating;
		this.playerRole = playerRole;
		this.playerImage = playerImage;
		this.manager=manager;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public double getPlayerRating() {
		return playerRating;
	}

	public void setPlayerRating(double playerRating) {
		this.playerRating = playerRating;
	}

	public PlayerRole getPlayerRole() {
		return playerRole;
	}

	public void setPlayerRole(PlayerRole playerRole) {
		this.playerRole = playerRole;
	}

	public String getPlayerImage() {
		return playerImage;
	}

	public void setPlayerImage(String playerImage) {
		this.playerImage = playerImage;
	}

	public long getPlayerID() {
		return playerID;
	}
	
	public boolean checkIfManager() {
		return manager;
	}
	
	public void setManager(boolean manager) {
		this.manager=manager;
	}

	@Override
	public String toString() {
		return "Player [playerID=" + playerID + ", playerName=" + playerName + ", playerRating=" + playerRating
				+ ", playerRole=" + playerRole + ", playerImage=" + playerImage + "]";
	}

	@Override
	public int compareTo(Object p) {
		Player playerToCompare=(Player) p;
		if(this.playerRating>playerToCompare.getPlayerRating())
			return -1;
		if (this.playerRating==playerToCompare.getPlayerRating()) {
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
	
	
	
}
