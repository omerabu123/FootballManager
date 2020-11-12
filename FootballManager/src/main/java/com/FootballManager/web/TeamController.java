package com.FootballManager.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FootballManager.beans.Team;
import com.FootballManager.exceptions.CannotFindEntity;
import com.FootballManager.services.TeamService;

@RestController
public class TeamController {

	@Autowired
	private TeamService teamService;
	
	@GetMapping("getOneTeam")
	public ResponseEntity<Object> getOneTeam(@RequestParam("teamID") long teamID){
		try {
			return ResponseEntity.ok().body(teamService.getOneTeam(teamID));
		} catch (CannotFindEntity e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
