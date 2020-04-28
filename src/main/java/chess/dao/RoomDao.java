package chess.dao;

import chess.dao.exceptions.DaoNoneSelectedException;
import chess.dto.RoomDto;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class RoomDao {
	private final ConnectionDao connectionDao;

	public RoomDao(final ConnectionDao connectionDao) {
		this.connectionDao = connectionDao;
	}

	public int addRoomByRoomName(final String roomName) throws SQLException {
		final String query = "INSERT INTO room (room_name) VALUES (?)";

		try (final Connection connection = connectionDao.getConnection();
			 final PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, roomName);
			return preparedStatement.executeUpdate();
		}
	}

	public RoomDto findRoomByRoomName(final String roomName) throws SQLException {
		final String query = "SELECT * FROM room WHERE room_name = ?";

		try (final Connection connection = connectionDao.getConnection();
			 final PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, roomName);
			return prepareRoomDto(preparedStatement);
		}
	}

	private RoomDto prepareRoomDto(final PreparedStatement preparedStatement) throws SQLException {
		try (final ResultSet resultSet = preparedStatement.executeQuery()) {
			validateHasResult(resultSet);
			return new RoomDto(resultSet.getString("room_name"));
		}
	}

	private void validateHasResult(final ResultSet resultSet) throws SQLException {
		if (!resultSet.next()) {
			throw new DaoNoneSelectedException();
		}
	}

	public List<RoomDto> findAllRooms() throws SQLException {
		final String query = "SELECT * FROM room";

		try (final Connection connection = connectionDao.getConnection();
			 final PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			return prepareRoomDtos(preparedStatement);
		}
	}

	private List<RoomDto> prepareRoomDtos(final PreparedStatement preparedStatement) throws SQLException {
		try (final ResultSet resultSet = preparedStatement.executeQuery()) {
			return collectRoomDtos(resultSet);
		}
	}

	private List<RoomDto> collectRoomDtos(final ResultSet resultSet) throws SQLException {
		final List<RoomDto> roomDtos = new ArrayList<>();
		while (resultSet.next()) {
			roomDtos.add(new RoomDto(resultSet.getString("room_name")));
		}
		return roomDtos;
	}

	public int deleteRoomByRoomName(final String roomName) throws SQLException {
		final String query = "DELETE FROM room WHERE room_name = ?";

		try (final Connection connection = connectionDao.getConnection();
			 final PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, roomName);
			return preparedStatement.executeUpdate();
		}
	}
}
