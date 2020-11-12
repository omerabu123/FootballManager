package com.FootballManager.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FootballManager.beans.Field;
import com.FootballManager.beans.Player;
import com.FootballManager.beans.Team;
import com.FootballManager.services.FieldService;

@RestController
@RequestMapping("field")
@CrossOrigin("*")
public class FieldController{

	@Autowired
	private FieldService fieldService;
	
	
	@PostMapping("addField")
	public ResponseEntity<Object> addField(@RequestBody Field field){
		return ResponseEntity.ok().body(fieldService.addField(field));
	}
	@GetMapping("getFieldPlayers")
	public ResponseEntity<Object> getAllFieldPlayers(@RequestParam("fieldID") long fieldID){
		return ResponseEntity.ok().body(fieldService.getAllFieldPlayers(fieldID));
	}
	@PostMapping("addOnePlayerToField")
	public ResponseEntity<Object> addPlayerToField(@RequestParam("fieldID") long fieldID,@RequestBody Player player){
		fieldService.addOnePlayerToField(player,fieldID);
		return ResponseEntity.ok().body("Player Added");
	}
	@PostMapping("shuffleTeams")
	public ResponseEntity<Object> shuffleTeams(@RequestParam("fieldID") long fieldID,
			@RequestParam("numberofteams") int numberofteams,@RequestBody List<Player> playersPlayingToday){
		return ResponseEntity.ok().body(fieldService.shuffleTeams(playersPlayingToday,numberofteams,fieldID));
	}
	@PostMapping("acceptTeams")
	public ResponseEntity<Object> acceptTeams(@RequestBody List<Team> teams){
		fieldService.acceptTeams(teams);
		return ResponseEntity.ok().body("Teams Accepted!");
	}
}
