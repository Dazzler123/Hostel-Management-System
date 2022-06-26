package lk.ijse.hms.bo.custom;

import lk.ijse.hms.bo.SuperBO;
import lk.ijse.hms.dto.RoomDTO;

public interface NewRoomBO extends SuperBO {
    public boolean saveRoom(RoomDTO roomDTO);
}
