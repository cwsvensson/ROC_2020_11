package com.player.service.impl;

import java.util.List;

import com.player.dao.PlayerSearchDAO;
import com.player.dao.impl.PlayerSearchDAOImpl;
import com.player.exception.BusinessException;
import com.player.model.Player;
import com.player.service.PlayerSearchService;

public class PlayerSearchServiceImpl implements PlayerSearchService {

	private PlayerSearchDAO searchDAO = new PlayerSearchDAOImpl();

	@Override
	public Player getPlayerById(int id) throws BusinessException {
		Player player = null;
		if (id >= 1000 && id <= 9999) {
			// code here for DAO
			player = searchDAO.getPlayerById(id);
		} else {
			throw new BusinessException("Entered Player ID " + id + " is INVALID!!!.. Please ReEnter");
		}
		return player;
	}

	@Override
	public List<Player> getAllPlayers() throws BusinessException {
		List<Player> playersList = null;
		playersList = searchDAO.getAllPlayers();
		return playersList;
	}

	@Override
	public List<Player> getPlayersByLastName(String lastName) throws BusinessException {
		List<Player> playerListName=null;
		playerListName=searchDAO.getPlayersByLastName(lastName);
		
		return playerListName;
	}

	@Override
	public List<Player> getPlayersByAge(int age) throws BusinessException {
		List<Player> playersList = null;
		if (age >= 18 && age <= 70) {
			// code here for DAO
			System.out.println("Fetching all players of age "+ age);
			playersList = searchDAO.getPlayersByAge(age);
		} else if (age < 0){
			throw new BusinessException("Please Enter An Age of Someone Who Is At Least Born");
		} else if (age < 18) {
			throw new BusinessException("Invalid - Players must be at least 18 to be on a team.");
		} else {
			throw new BusinessException("That's a bit old.  By now they are retired or dead.");
		}
		return playersList;
	}

	@Override
	public Player getPlayerByContactNumber(long contact) throws BusinessException {
		Player player = null;
		if (contact >= 100000 && contact <= 999999) {
			// code here for DAO
			player = searchDAO.getPlayerByContactNumber(contact);
		} else {
			throw new BusinessException("Entered Player Contact Number " + contact + " is INVALID!!!.. Please ReEnter");
		}
		return player;
	}

	@Override
	public List<Player> getPlayersByTeamName(String teamName) throws BusinessException {
			List<Player> playerListTeam=null;
			playerListTeam = searchDAO.getPlayersByTeamName(teamName);
			
			return playerListTeam;
	}

	@Override
	public List<Player> getPlayersByGender(String gender) throws BusinessException {
		List<Player> playerListGender=null;
		if(gender!=null && gender.matches("[MFO]{1}")) {
			playerListGender=searchDAO.getPlayersByGender(gender);
		}else {
			throw new BusinessException("Entered Gender "+gender+" is INVALID...");
		}
		return playerListGender;
	}

}
