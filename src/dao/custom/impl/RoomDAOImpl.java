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
}
