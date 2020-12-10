package com.FootballManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.FootballManager.beans.Player;
import com.FootballManager.beans.PlayerRole;
import com.FootballManager.beans.Team;
import com.FootballManager.services.FieldService;
import com.FootballManager.services.TeamService;

@SpringBootApplication
public class FootballManagerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=SpringApplication.run(FootballManagerApplication.class, args);
		FieldService teamService=ctx.getBean(FieldService.class);
//		List<PlayerRole> playerRoles=new ArrayList<>();
//		playerRoles.add(PlayerRole.ATT);
		Player yagen=new Player("dor yagen", 8, PlayerRole.ATT, "C:\\Users\\omera\\Desktop\bibi.jpg", false);
//		playerRoles.remove(0);
//		playerRoles.add(PlayerRole.Mid);
		Player nadavA=new Player("benami", 10, PlayerRole.ATT, "C:\\Users\\omera\\Desktop\bibi.jpg", false);
//		playerRoles.remove(0);
//		playerRoles.add(PlayerRole.ATT);
		Player ivgi=new Player("ivgi", 7, PlayerRole.DEF, "C:\\Users\\omera\\Desktop\bibi.jpg", false);
//		playerRoles.remove(0);
//		playerRoles.add(PlayerRole.ATT);
		Player roiCohen=new Player("roi cohen", 9, PlayerRole.DEF, "C:\\Users\\omera\\Desktop\bibi.jpg", false);
//		playerRoles.remove(0);
//		playerRoles.add(PlayerRole.ATT);
		Player adir=new Player("adir", 9, PlayerRole.ATT, "C:\\Users\\omera\\Desktop\bibi.jpg", false);
//		playerRoles.remove(0);
//		playerRoles.add(PlayerRole.ATT);
		Player barashi=new Player("tal barashi",5, PlayerRole.MID, "C:\\Users\\omera\\Desktop\bibi.jpg", false);
//		playerRoles.remove(0);
//		playerRoles.add(PlayerRole.ATT);
		Player omer=new Player("omer abukarat", 10, PlayerRole.ATT, "C:\\Users\\omera\\Desktop\bibi.jpg", false);
//		playerRoles.remove(0);
//		playerRoles.add(PlayerRole.ATT);
		Player kerem=new Player("omer kerem", 5, PlayerRole.DEF, "C:\\Users\\omera\\Desktop\bibi.jpg", false);
//		playerRoles.remove(0);
//		playerRoles.add(PlayerRole.ATT);
		Player yarin=new Player("yarin ben david", 6, PlayerRole.MID, "C:\\Users\\omera\\Desktop\bibi.jpg", false);
//		playerRoles.remove(0);
//		playerRoles.add(PlayerRole.ATT);
		Player yair=new Player("yair hogeg", 9, PlayerRole.DEF, "C:\\Users\\omera\\Desktop\bibi.jpg", false);
//		playerRoles.remove(0);
//		playerRoles.add(PlayerRole.ATT);
		Player amsalem=new Player("amsalem", 5, PlayerRole.DEF, "C:\\Users\\omera\\Desktop\bibi.jpg", false);
//		playerRoles.remove(0);
//		playerRoles.add(PlayerRole.ATT);
		Player yoav=new Player("yoav", 7, PlayerRole.MID, "C:\\Users\\omera\\Desktop\bibi.jpg", false);
		Player jelnik=new Player("gil jelnik",6, PlayerRole.MID, "C:\\Users\\omera\\Desktop\bibi.jpg",false);
		Player shai=new Player("shai",6, PlayerRole.DEF, "C:\\Users\\omera\\Desktop\bibi.jpg",false);
		Player nasimi=new Player("nasimi",7, PlayerRole.MID, "C:\\Users\\omera\\Desktop\bibi.jpg",false);
		List<Player> players=new ArrayList<>();
		players=Arrays.asList(yagen,nadavA,ivgi,adir,omer,barashi,yarin,yair,amsalem,yoav,roiCohen,kerem,jelnik,shai,nasimi);
		
		List<Team> teams=teamService.shuffleTeams(players, 3,2);
		for (Team team : teams) {
			System.out.println(team);
		}
	}

}
