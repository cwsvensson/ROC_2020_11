package my.app.jdbc;

import my.app.jdbc.dao.PlayerDAO;
import my.app.jdbc.dao.impl.PlayerDAOImpl;
import my.app.jdbc.exception.PlayerException;
import my.app.jdbc.model.Player;

public class STS4Players {

	public static void main(String[] args) {
		
		PlayerDAO playerDAO=new PlayerDAOImpl();
		
		// 'C' = Create
		try {
			Player player=new Player(1011, "Fanny", "Fatima", "Rockers", 23, "F" , 9123467890L);
			int cnt = playerDAO.createPlayer(player);
			System.out.println("Creation - Player 1011 created in database.  Creation count = " + cnt);
			
		} catch(PlayerException e) {
			System.out.println(e.getMessage());
		}
		
		// 'R' = Read
		try {
			int id=1004;
			Player player=playerDAO.getPlayerById(id);
			if(player!=null) {
				System.out.println("Read - Player found with id "+id+" details are : ");
				System.out.println("  - " + player);
		    }
			
		} catch (PlayerException e) {
			System.out.println(e.getMessage());
		}

		// 'U' = Update
		try {
			int id=1001;
			Player player=playerDAO.getPlayerById(id);
			if(player!=null) {
				player.setContact(player.getContact()+1);
				playerDAO.updatePlayerContact(id, player.getContact());
				System.out.println("Update - Contact for 1001 is now : "+player.getContact());
			}
			
		} catch (PlayerException e) {
			System.out.println(e.getMessage());
		}
		
		// 'D' = Delete
		try {		
			int id = 1003;
			Player player=playerDAO.getPlayerById(id);
			if(player!=null) {
				System.out.println("Deletion - Player : "+id+", Name : "+player.getFirstName()+
						" Deletion count = " + playerDAO.deletePlayer(id));
			}
			
		} catch (PlayerException e) {
			System.out.println(e.getMessage());
		}

	}

}