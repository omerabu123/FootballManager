package com.FootballManager.beans;

import java.util.List;

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
public class Field {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long fieldID;
	@Column
	private String name;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Player> playerList;
	
	public Field() {}

	public Field(long fieldID, String name, List<Player> playerList) {
		super();
		this.fieldID = fieldID;
		this.name = name;
		this.playerList = playerList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}

	public long getFieldID() {
		return fieldID;
	}

	@Override
	public String toString() {
		return "Field [fieldID=" + fieldID + ", name=" + name + ", playerList=" + playerList + "]";
	}
	
 }
