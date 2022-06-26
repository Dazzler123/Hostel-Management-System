package lk.ijse.hms.dao.custom;

import lk.ijse.hms.dao.CrudDAO;
import lk.ijse.hms.entity.Room;

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
