package com.FootballManager.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FootballManager.beans.Field;
import com.FootballManager.beans.Player;

public interface FieldRepository extends JpaRepository<Field, Long>{

}
