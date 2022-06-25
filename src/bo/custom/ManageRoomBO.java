package bo.custom;

import dto.RoomDTO;

import java.util.ArrayList;

public interface ManageRoomBO {
    public ArrayList<RoomDTO> loadAll();
    public RoomDTO getRoom(String id);
}
