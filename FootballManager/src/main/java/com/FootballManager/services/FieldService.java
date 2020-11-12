package com.FootballManager.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FootballManager.beans.Field;
import com.FootballManager.beans.GameSession;
import com.FootballManager.beans.Player;
import com.FootballManager.beans.PlayerRole;
import com.FootballManager.beans.Team;
import com.FootballManager.db.FieldDB;
import com.FootballManager.db.FieldRepository;
import com.FootballManager.db.GameSessionDB;

@Service
public class FieldService {

	@Autowired
	private FieldDB fieldDB;
	
	@Autowired
	private GameSessionDB gameSessionDB;
	
	private long fieldID;
	
	private Field thisField;
	
	public List<Player> getAllFieldPlayers(long fieldID){
		return fieldDB.getAllFieldPlayers(fieldID);
	}

	public Field addField(Field field) {
		return fieldDB.addField(field);
	}

	public void addOnePlayerToField(Player player,long fieldid) {
		thisField=fieldDB.getOneField(fieldid);
		List<Player> fieldPlayers=thisField.getPlayerList();
		fieldPlayers.add(player);
		thisField.setPlayerList(fieldPlayers);
		fieldDB.updateField(thisField);
	}

	public List<Team> shuffleTeams(List<Player> players, int numberOfTeams, long fieldID2) {
		List<Team> readyTeams=new ArrayList<Team>();
		int teamsLeftToFill=numberOfTeams;
		int maxPlayersOneTeam;
		if (players.size()%numberOfTeams==0)
		maxPlayersOneTeam=players.size()/numberOfTeams;
		else 
		maxPlayersOneTeam=(players.size()/numberOfTeams)+1;
		List<Team> teams=new ArrayList<Team>();
		Set<Player> attPlayers = new TreeSet<Player>();
		Set<Player> midPlayers = new TreeSet<Player>();
		Set<Player> defPlayers = new TreeSet<Player>();
		for (Player player : players) {
			if (player.getPlayerRole() == PlayerRole.ATT) {
				attPlayers.add(player);
			}
			if (player.getPlayerRole()== PlayerRole.Def) {
				defPlayers.add(player);
			}
			if (player.getPlayerRole()== PlayerRole.Mid) {
				midPlayers.add(player);
			}
		}
		System.out.println("Attack Players By Ratings:" + attPlayers);
		System.out.println("Midfield Players By Ratings:" + midPlayers);
		System.out.println("Defending Players By Ratings:" + defPlayers);
		char name='A';
		for(int i=0;i<numberOfTeams;i++) {
			teams.add(new Team(name,new ArrayList<Player>()));
			System.out.println(name);
		 	name=(char)(name+1);
		}
		List<Player> defPlayersList=new ArrayList<Player>();
		List<Player> attPlayersList=new ArrayList<Player>();
		List<Player> midPlayersList=new ArrayList<Player>();
		for (Player player : defPlayers) {
			defPlayersList.add(player);
		}
		for (Player player : attPlayers) {
			attPlayersList.add(player);	
		}
		for (Player player : midPlayers) {
			midPlayersList.add(player);
		}
		for(int k=0;k<players.size();k++) {
			int j=minRatingTeamIndex(teams);
			while(!defPlayersList.isEmpty()) {
				if (teams.get(j).getTeamPlayers().size()==maxPlayersOneTeam) {
					readyTeams.add(teams.get(j));
					teams.remove(j);
					j=minRatingTeamIndex(teams);
				}
				Team team=teams.get(j);
				team.addPlayerToTeam(defPlayersList.get(0));
				defPlayersList.remove(0);
				j++;
				if (j==teamsLeftToFill)
					j=0;
			}
			j=minRatingTeamIndex(teams);
			while(!midPlayersList.isEmpty()) {
				if (teams.get(j).getTeamPlayers().size()==maxPlayersOneTeam) {
					readyTeams.add(teams.get(j));
					teams.remove(j);
					j=minRatingTeamIndex(teams);
				}
				Team team=teams.get(j);
				team.addPlayerToTeam(midPlayersList.get(0));
				midPlayersList.remove(0);
				j++;
				if (j==teamsLeftToFill)
					j=0;
			}
			j=minRatingTeamIndex(teams);
			while(!attPlayersList.isEmpty()) {
				if (teams.get(j).getTeamPlayers().size()==maxPlayersOneTeam) {
					readyTeams.add(teams.get(j));
					teams.remove(j);
					j=minRatingTeamIndex(teams);
				}
				Team team=teams.get(j);
				team.addPlayerToTeam(attPlayersList.get(0));
				attPlayersList.remove(0);
				j++;
				if (j==teamsLeftToFill)
					j=0;
			}
		}
		for (Team team : teams) {
			readyTeams.add(team);
		}
		return readyTeams;
	}
	
	public static int minRatingTeamIndex(List<Team> teams){
		Random rnd=new Random();
		int randomTeam=rnd.nextInt(teams.size());
		double minRating=teams.get(randomTeam).getTeamRating();
		int index=0;
		int indexOfMin=randomTeam;
		for (Team team : teams) {
			if(team.getTeamRating()<minRating) {
				minRating=team.getTeamRating();
			    indexOfMin=index;
			}
			index++;
		}
		return indexOfMin;
	}

	public void acceptTeams(List<Team> teams) {
		GameSession gameSession=new GameSession(teams.size(),teams);
		gameSessionDB.addGameSession(gameSession);
	}

}
