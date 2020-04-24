package chess.service;

import chess.dao.RoomDao;
import chess.dto.RoomDto;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ChessRoomsService {
	private final RoomDao roomDao;

	public ChessRoomsService(final RoomDao roomDao) {
		this.roomDao = roomDao;
	}

	public List<RoomDto> findAllRooms() throws SQLException {
		return roomDao.findAllRooms();
	}

	public RoomDto findRoomByRoomName(final String roomName) throws SQLException {
		return roomDao.findRoomByRoomName(roomName);
	}

	public int addRoomByRoomName(final String roomName) throws SQLException {
		return roomDao.addRoomByRoomName(roomName);
	}

	public int deleteRoomByRoomName(final String roomName) throws SQLException {
		return roomDao.deleteRoomByRoomName(roomName);
	}
}
