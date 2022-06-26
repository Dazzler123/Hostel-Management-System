package bo.custom;

import bo.SuperBO;
import dto.RoomDTO;

public interface NewRoomBO extends SuperBO {
    public boolean saveRoom(RoomDTO roomDTO);
}
