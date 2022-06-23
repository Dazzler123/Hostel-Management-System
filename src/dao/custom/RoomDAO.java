package dao.custom;

import entity.Room;

import java.util.List;

public interface RoomDAO {
    public List<Room> getAll();
    public Room get(String id);
    public boolean updateQty(String id, String qty);
}
