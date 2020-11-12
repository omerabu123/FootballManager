package com.FootballManager.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FootballManager.exceptions.CannotFindEntity;
import com.FootballManager.services.GameSessionService;

@RestController
@RequestMapping("gameSessions")
@CrossOrigin("*")
public class GameSessionController {

	@Autowired
	private GameSessionService gameSessionService;
	@GetMapping("getOneSession")
	public ResponseEntity<Object> getOneSession(@RequestParam("gameSessionID") long gameSessionID){
		try{
			return ResponseEntity.ok().body(gameSessionService.getOneGameSession(gameSessionID));
		} catch(CannotFindEntity e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}
}
