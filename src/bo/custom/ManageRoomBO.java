package bo.custom;

import bo.SuperBO;
import dto.RoomDTO;

import java.util.ArrayList;

public interface ManageRoomBO extends SuperBO {
    public ArrayList<RoomDTO> loadAll();
    public RoomDTO getRoom(String id);
    public boolean updateRoom(RoomDTO roomDTO);
    public boolean deleteRoom(String id);
}
