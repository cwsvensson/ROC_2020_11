package com.player.dao.dbutil;

public class PlayerSearchQueries {

	public static final String GET_PLAYER_BY_ID = 
			"select  first_name, last_name, age, gender, teamname, contact from jdbc.player where id=?";
	
	public static final String GET_ALL_PLAYERS = 
			"select id, first_name, last_name, age, gender, teamname, contact from jdbc.player";
	
	public static final String GET_PLAYERS_BY_GENDER = 
			"select id, first_name, last_name, age, teamname, contact from jdbc.player where gender=?";
	
	public static final String GET_PLAYERS_BY_LAST_NAME =
			"select id, first_name, age, gender, teamname, contact from jdbc.player where last_name=?";
	
	public static final String GET_PLAYERS_BY_AGE =
			"select id, first_name, last_name, gender, teamname, contact from jdbc.player where age=?";
	
	public static final String GET_PLAYER_BY_CONTACT_NUMBER =
			"select id, first_name, last_name, age, gender, teamname from jdbc.player where contact=?";
	
	public static final String GET_PLAYERS_BY_TEAM_NAME =
			"select id, first_name, last_name, age, gender, contact from jdbc.player where teamname=?";	
}
