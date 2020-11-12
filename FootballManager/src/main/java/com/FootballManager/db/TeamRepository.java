package com.FootballManager.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FootballManager.beans.Team;

public interface TeamRepository extends JpaRepository<Team, Long>{

}
