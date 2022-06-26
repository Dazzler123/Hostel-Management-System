package dao.custom;

import dao.CrudDAO;
import entity.Room;

import java.util.List;

public interface RoomDAO extends CrudDAO<Room,String> {
    public List<Room> getAll();
    public Room get(String id);
    public boolean updateQty(String id, String qty);
    public List<Room> search(String id);
    public boolean save(Room room);
    public boolean update(Room room);
    public boolean delete(String id);
}
