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
         /*String hql = "FROM Owner";  // need to add JPA Facet to the Module
        Query query = session.createQuery(hql);
        List<Owner> ownerList = query.list();

        for (Owner owner : ownerList) {
            System.out.println(owner.getoId() + " : " + owner.getName() + " : " + owner.getPetList());
            System.out.println(owner);
        }*/

        String hql = "FROM room";
        Query query = session.createQuery(hql);

        transaction.commit();
        session.close();

        return query.list();

    }
}
