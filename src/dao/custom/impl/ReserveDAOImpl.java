package dao.custom.impl;

import dao.custom.ReserveDAO;
import entity.Reserve;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.util.List;

public class ReserveDAOImpl implements ReserveDAO {
    @Override
    public boolean save(Reserve reserve) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(reserve);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public String generateID() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("Select max(res.res_id) FROM Reserve res");
        List list = query.list();

        transaction.commit();
        session.close();

        if (list.get(0) == null) {
            return "RES-0001";
        } else {
            String id = String.valueOf(list.get(0));
            Long resID = Long.parseLong(id.substring(4, id.length()));
            resID++;
            return "RES-" + String.format("%04d", resID);
        }
    }
}
