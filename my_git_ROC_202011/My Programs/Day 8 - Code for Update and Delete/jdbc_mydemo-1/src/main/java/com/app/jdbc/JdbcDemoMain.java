package com.app.jdbc;

import com.app.jdbc.dao.PlayerDAO;
import com.app.jdbc.dao.impl.PlayerDAOImpl;
import com.app.jdbc.exception.BusinessException;
import com.app.jdbc.model.Player;

public class JdbcDemoMain {

	public static void main(String[] args) {
	
		//Player player=new Player(106, "Fatima", "Rockers",23 ,9123467890L, "F");
		
		PlayerDAO playerDAO=new PlayerDAOImpl();
		
		try {
			int id=1001;
			Player player=playerDAO.getPlayerById(id);
			if(player!=null) {
				System.out.println("Player found with id "+id+" details are : ");
				System.out.println(player);
				player.setContact(player.getContact()+1);
				playerDAO.updatePlayerContact(id, player.getContact());
				System.out.println("After update, Contact now is : "+player.getContact());
		    }
			
			id = 1003;
			player=playerDAO.getPlayerById(id);
			if(player!=null) {
				System.out.println("Deleting Player : "+id+", Name : "+player.getName());
				System.out.println(player);
				playerDAO.deletePlayer(id);
			}
			
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}

	}

}
