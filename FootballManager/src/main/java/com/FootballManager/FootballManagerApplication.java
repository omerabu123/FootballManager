package com.FootballManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.FootballManager.beans.Player;
import com.FootballManager.beans.PlayerRole;
import com.FootballManager.services.TeamService;

@SpringBootApplication
public class FootballManagerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=SpringApplication.run(FootballManagerApplication.class, args);
		TeamService teamService=ctx.getBean(TeamService.class);
//		List<PlayerRole> playerRoles=new ArrayList<>();
//		playerRoles.add(PlayerRole.ATT);
//		Player yagen=new Player("dor yagen", 7, playerRoles, "C:\\Users\\omera\\Desktop\bibi.jpg", false);
//		playerRoles.remove(0);
//		playerRoles.add(PlayerRole.Mid);
//		Player benami=new Player("benami", 4, playerRoles, "C:\\Users\\omera\\Desktop\bibi.jpg", false);
//		playerRoles.remove(0);
//		playerRoles.add(PlayerRole.ATT);
//		Player ivgi=new Player("ivgi", 6, playerRoles, "C:\\Users\\omera\\Desktop\bibi.jpg", false);
//		playerRoles.remove(0);
//		playerRoles.add(PlayerRole.ATT);
//		Player roiCohen=new Player("roi cohen", 8, playerRoles, "C:\\Users\\omera\\Desktop\bibi.jpg", false);
//		playerRoles.remove(0);
//		playerRoles.add(PlayerRole.ATT);
//		Player adir=new Player("adir", 7, playerRoles, "C:\\Users\\omera\\Desktop\bibi.jpg", false);
//		playerRoles.remove(0);
//		playerRoles.add(PlayerRole.ATT);
//		Player barashi=new Player("tal barashi",5, playerRoles, "C:\\Users\\omera\\Desktop\bibi.jpg", false);
//		playerRoles.remove(0);
//		playerRoles.add(PlayerRole.ATT);
//		Player omer=new Player("omer abukarat", 8, playerRoles, "C:\\Users\\omera\\Desktop\bibi.jpg", false);
//		playerRoles.remove(0);
//		playerRoles.add(PlayerRole.ATT);
//		Player kerem=new Player("omer kerem", 5, playerRoles, "C:\\Users\\omera\\Desktop\bibi.jpg", false);
//		playerRoles.remove(0);
//		playerRoles.add(PlayerRole.ATT);
//		Player yarin=new Player("yarin ben david", 5, playerRoles, "C:\\Users\\omera\\Desktop\bibi.jpg", false);
//		playerRoles.remove(0);
//		playerRoles.add(PlayerRole.ATT);
//		Player yair=new Player("yair hogeg", 8, playerRoles, "C:\\Users\\omera\\Desktop\bibi.jpg", false);
//		playerRoles.remove(0);
//		playerRoles.add(PlayerRole.ATT);
//		Player royMizrahi=new Player("roy mizrahi", 6, playerRoles, "C:\\Users\\omera\\Desktop\bibi.jpg", false);
//		playerRoles.remove(0);
//		playerRoles.add(PlayerRole.ATT);
//		Player Magen=new Player("magen", 7, playerRoles, "C:\\Users\\omera\\Desktop\bibi.jpg", false);
//		List<Player> players=new ArrayList<>();
//		players=Arrays.asList(yagen,benami,ivgi,adir,omer,barashi,yarin,yair,royMizrahi,Magen,roiCohen,kerem);
//		teamService.shuffleTeamsTest(players);
	}

}
