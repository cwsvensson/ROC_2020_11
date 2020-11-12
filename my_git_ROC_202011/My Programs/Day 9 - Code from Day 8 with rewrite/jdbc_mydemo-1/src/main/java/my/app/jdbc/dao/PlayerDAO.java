package my.app.jdbc.dao;

import my.app.jdbc.exception.PlayerException;
import my.app.jdbc.model.Player;

/* This is the Data Access Object:  It is the DB related code put
here as an Interface to show the methods that must be written to
access the DB according to the DB model in DBeaver.
*/

public interface PlayerDAO {
	
	public int createPlayer(Player player)throws PlayerException;
	
	public Player getPlayerById(int id) throws PlayerException;
	
	public int updatePlayerContact(int id, long newContact) throws PlayerException;
	
	public int deletePlayer(int id)throws PlayerException;
}