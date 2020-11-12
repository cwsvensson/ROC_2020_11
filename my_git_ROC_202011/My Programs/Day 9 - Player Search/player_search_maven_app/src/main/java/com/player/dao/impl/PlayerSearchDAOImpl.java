package com.player.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.player.dao.PlayerSearchDAO;
import com.player.dao.dbutil.PlayerSearchQueries;
import com.player.dao.dbutil.PostresSqlConnection;
import com.player.exception.BusinessException;
import com.player.model.Player;

public class PlayerSearchDAOImpl  implements PlayerSearchDAO{

	@Override
	public Player getPlayerById(int id) throws BusinessException {
		Player player = null;
		try (Connection connection = PostresSqlConnection.getConnection()) {
			String sql = PlayerSearchQueries.GET_PLAYER_BY_ID;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				player = new Player(id, resultSet.getString("first_name"), resultSet.getString("last_name"),
						                resultSet.getString("teamName"),resultSet.getInt("age"),
						                resultSet.getLong("contact"), resultSet.getString("gender"));
			}else {
				throw new BusinessException("Invalid ID!!!... No matching records found for the ID = "+id);
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e); // take off this line when in production
			throw new BusinessException("Internal error occured.. Kindly contact SYSADMIN");
		}
		return player;
	}

	@Override
	public List<Player> getAllPlayers() throws BusinessException {
		List<Player> playerList = new ArrayList<>();
		try (Connection connection = PostresSqlConnection.getConnection()) {
			String sql = PlayerSearchQueries.GET_ALL_PLAYERS;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Player player = new Player(resultSet.getInt("id"), resultSet.getString("first_name"),
						resultSet.getString("last_name"), resultSet.getString("teamName"),resultSet.getInt("age"),
		                resultSet.getLong("contact"), resultSet.getString("gender"));
				playerList.add(player);
			}
			if(playerList.size()==0)
			{
				throw new BusinessException("No Player Records Available");
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e); // take off this line when in production
			throw new BusinessException("Internal error occured.. Kindly contact SYSADMIN");
		}
		return playerList;
	}

	@Override
	public List<Player> getPlayersByLastName(String lastName) throws BusinessException {
		List<Player> playerList = new ArrayList<>();
		try (Connection connection = PostresSqlConnection.getConnection()) {
			String sql = PlayerSearchQueries.GET_PLAYERS_BY_LAST_NAME;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, lastName);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Player player = new Player(resultSet.getInt("id"), resultSet.getString("first_name"),
						                   lastName, resultSet.getString("teamName"), resultSet.getInt("age"),
						                   resultSet.getLong("contact"), resultSet.getString("gender"));
				playerList.add(player);
			}
			if(playerList.size()==0)
			{
				throw new BusinessException("No Players Found for Name: "+lastName);
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e); // take off this line when in production
			throw new BusinessException("Internal error occured.. Kindly contact SYSADMIN");
		}
		return playerList;
	}

	@Override
	public List<Player> getPlayersByAge(int age) throws BusinessException {
		List<Player> playerList = new ArrayList<>();
		try (Connection connection = PostresSqlConnection.getConnection()) {
			String sql = PlayerSearchQueries.GET_PLAYERS_BY_AGE;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, age);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Player player = new Player(resultSet.getInt("id"), resultSet.getString("first_name"),
						                   resultSet.getString("last_name"), resultSet.getString("teamName"),
						                   age, resultSet.getLong("contact"), resultSet.getString("gender"));
				playerList.add(player);
			}
			if(playerList.size()==0)
			{
				throw new BusinessException("No Players Found Aged "+age);
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e); // take off this line when in production
			throw new BusinessException("Internal error occured.. Kindly contact SYSADMIN");
		}
		return playerList;
	}

	@Override
	public Player getPlayerByContactNumber(long contact) throws BusinessException {
		Player player = null;
		try (Connection connection = PostresSqlConnection.getConnection()) {
			String sql = PlayerSearchQueries.GET_PLAYER_BY_CONTACT_NUMBER;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, contact);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				player = new Player(resultSet.getInt("id"), resultSet.getString("first_name"),
						            resultSet.getString("last_name"), resultSet.getString("teamName"),
						            resultSet.getInt("age"), contact, resultSet.getString("gender"));
			}else {
				throw new BusinessException("Invalid Contact!!!... No matching records found for the Contact Number = "+contact);
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e); // take off this line when in production
			throw new BusinessException("Internal error occured.. Kindly contact SYSADMIN");
		}
		return player;
	}

	@Override
	public List<Player> getPlayersByTeamName(String teamName) throws BusinessException {
		List<Player> playerList = new ArrayList<>();
		try (Connection connection = PostresSqlConnection.getConnection()) {
			String sql = PlayerSearchQueries.GET_PLAYERS_BY_TEAM_NAME;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, teamName);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Player player = new Player(resultSet.getInt("id"), resultSet.getString("first_name"),
						resultSet.getString("last_name"), teamName, resultSet.getInt("age"),
						resultSet.getLong("contact"), resultSet.getString("gender"));
				playerList.add(player);
			}
			if(playerList.size()==0)
			{
				throw new BusinessException("No Players Found for a Team Called: "+teamName);
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e); // take off this line when in production
			throw new BusinessException("Internal error occured.. Kindly contact SYSADMIN");
		}
		return playerList;
	}

	@Override
	public List<Player> getPlayersByGender(String gender) throws BusinessException {
		List<Player> playerList = new ArrayList<>();
		try (Connection connection = PostresSqlConnection.getConnection()) {
			String sql = PlayerSearchQueries.GET_PLAYERS_BY_GENDER;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, gender.toUpperCase());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Player player = new Player(resultSet.getInt("id"), resultSet.getString("first_name"),
						                   resultSet.getString("last_name"), resultSet.getString("teamName"),
						                   resultSet.getInt("age"), resultSet.getLong("contact"), gender);
				playerList.add(player);
			}
			if(playerList.size()==0)
			{
				throw new BusinessException("No Players Found with Gender "+gender);
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e); // take off this line when in production
			throw new BusinessException("Internal error occured.. Kindly contact SYSADMIN");
		}
		return playerList;
	}

}
