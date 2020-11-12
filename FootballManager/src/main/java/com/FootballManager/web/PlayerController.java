package com.FootballManager.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FootballManager.beans.Player;
import com.FootballManager.exceptions.CannotFindEntity;
import com.FootballManager.exceptions.PlayerExists;
import com.FootballManager.exceptions.PlayerNotExists;
import com.FootballManager.services.PlayerService;

@RestController
@RequestMapping("player")
@CrossOrigin("*")
public class PlayerController {

	@Autowired
	private PlayerService playerService;
	
	@PostMapping("addPlayer")
	public ResponseEntity<Object> addPlayer(@RequestBody Player player){
		try {
			playerService.addPlayer(player);
		} catch (PlayerExists e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok().body("player Added");
	}
	
	@GetMapping("getOnePlayer")
	public ResponseEntity<Object> getOnePlayer(@RequestParam("playerID") long playerID){
		try {
			return ResponseEntity.ok().body(playerService.getOnePlayer(playerID));
		} catch (CannotFindEntity e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping("changePlayerRating")
	public ResponseEntity<Object> changeOnePlayerRating(@RequestParam("playerID") long playerID,@RequestParam("playerRating") double rating){
		playerService.changePlayerRating(playerID,rating);
		return ResponseEntity.ok().body("player rating changed");
	}
}
