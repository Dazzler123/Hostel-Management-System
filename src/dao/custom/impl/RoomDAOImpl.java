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
}
