package com.FootballManager.exceptions;

public class CannotFindEntity extends Exception {

	public CannotFindEntity(String message) {
		super("Cannot find entity: "+message);
	}
}
