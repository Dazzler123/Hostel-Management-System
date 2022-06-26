package dao.custom.impl;

import dao.custom.RoomDAO;
import entity.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    @Override
    public List<Room> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("FROM room");
        List<Room> roomList = query.list();

        transaction.commit();
        session.close();

        return roomList;
    }

    public Room get(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Room room = session.get(Room.class, id);

        transaction.commit();
        session.close();

        return room;
    }

    public boolean updateQty(String id, String qty) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("UPDATE room SET qty = : new_qty WHERE room_id = : id");
        query.setParameter("new_qty", qty);
        query.setParameter("id", id);
        int rowCount = query.executeUpdate();

        transaction.commit();
        session.close();

        if (rowCount > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<Room> search(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("FROM room WHERE room_id = : id");
        query.setParameter("id", id);
        List<Room> list = query.list();

        transaction.commit();
        session.close();

        return list;
    }

    public boolean save(Room room) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(room);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean update(Room room) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("UPDATE room SET type = : r_type, key_money = : r_keyMoney, qty = : r_qty WHERE room_id = : r_id");
        query.setParameter("r_type", room.getType());
        query.setParameter("r_keyMoney", room.getKey_money());
        query.setParameter("r_qty", room.getQty());
        query.setParameter("r_id", room.getRoom_id());
        int isUpdated = query.executeUpdate();

        transaction.commit();
        session.close();

        if (isUpdated > 0)
            return true;
        else {
            return false;
        }
    }

    public boolean delete(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Room room = session.get(Room.class, id);

        Query query1 = session.createQuery("DELETE FROM Reserve WHERE room_id = : r");
        query1.setParameter("r", room);
        int isDetached = query1.executeUpdate();

        Query query = session.createQuery("DELETE FROM room WHERE room_id = : id");
        query.setParameter("id", id);
        int isDeleted = query.executeUpdate();

        transaction.commit();
        session.close();

        if (isDetached > 0) {
            if (isDeleted > 0) {
                return true;
            }
        }
        return false;
    }


}
