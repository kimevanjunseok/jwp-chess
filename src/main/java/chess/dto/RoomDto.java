package chess.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("room")
public class RoomDto {
	@Id
	private int id;
	private final String roomName;

	public RoomDto(final String roomName) {
		this.roomName = roomName;
	}

	public int getId() {
		return id;
	}

	public String getRoomName() {
		return roomName;
	}
}