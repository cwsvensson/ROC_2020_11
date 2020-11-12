package my.app.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import my.app.jdbc.dao.PlayerDAO;
import my.app.jdbc.dbutil.MyPostresSqlConnection;
import my.app.jdbc.exception.PlayerException;
import my.app.jdbc.model.Player;

public class PlayerDAOImpl implements PlayerDAO {

	@Override
	public int createPlayer(Player player) throws PlayerException {
		int cntr = 0;
		try (Connection connection = MyPostresSqlConnection.getConnection()) {
			String sql = "INSERT INTO jdbc.player(id, first_name, last_name, age,"
					                           +  "gender, teamname, contact) "
					                           +  "VALUES(?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, player.getId());
			preparedStatement.setString(2, player.getFirstName());
			preparedStatement.setString(3, player.getLastName());
			preparedStatement.setInt(4, player.getAge());
			preparedStatement.setString(5, player.getGender());
			preparedStatement.setString(6, player.getTeamName());
			preparedStatement.setLong(7, player.getContact());

			cntr = preparedStatement.executeUpdate();

		} catch(SQLException | ClassNotFoundException e) {
			throw new PlayerException("Internal error occured.. Kindly contact SYSADMIN");
		}
		return cntr;
	}

	@Override
	public Player getPlayerById(int id) throws PlayerException {
		Player player = null;
		try (Connection connection = MyPostresSqlConnection.getConnection()) {
			String sql = "select  first_name, last_name, age, gender,"
		             +" teamname, contact from jdbc.player where id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				player = new Player(id,
						resultSet.getString("first_name"),
						resultSet.getString("last_name"),
						resultSet.getString("teamname"),
						resultSet.getInt("age"),
						resultSet.getString("gender"),
						resultSet.getLong("contact"));
			} else {
				throw new PlayerException("Invalid ID!!!... No matching records found for the ID = "+id);
			}
		} catch(SQLException | ClassNotFoundException e) {
			throw new PlayerException("Internal error occured.. Kindly contact SYSADMIN");
		}
		return player;
	}

	@Override
	public int updatePlayerContact(int id, long newContact) throws PlayerException {
		int cnt = 0;
		try (Connection connection = MyPostresSqlConnection.getConnection()) {
			String sql = "UPDATE jdbc.player SET contact = ? WHERE id = ?;"; //write update query here
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, newContact);
			preparedStatement.setInt(2, id);

			cnt = preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e); // take off this line when in production
			throw new PlayerException("Internal error occured.. Kindly contact SYSADMIN");
		}
		return cnt;
	}

	@Override
	public int deletePlayer(int id) throws PlayerException {
		int cnt = 0;
		try (Connection connection = MyPostresSqlConnection.getConnection()) {
			String sql = "DELETE FROM jdbc.player WHERE id = ?;"; //write here the delete query
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);

			cnt = preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e); // take off this line when in production
			throw new PlayerException("Internal error occured.. Kindly contact SYSADMIN");
		}
		return cnt;
	}
}
