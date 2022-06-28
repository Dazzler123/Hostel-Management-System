package lk.ijse.hms.dao.custom.impl;

import lk.ijse.hms.dao.custom.ReserveDAO;
import lk.ijse.hms.entity.Reserve;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import lk.ijse.hms.util.FactoryConfiguration;

import java.util.List;

public class ReserveDAOImpl implements ReserveDAO {
    @Override
    public List<Reserve> getAll() {
       return null;
    }

    @Override
    public Reserve get(String s) {
        return null;
    }

    @Override
    public List<Reserve> search(String s) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("FROM Reserve where student_id = : id AND status = : st");
        query.setParameter("id",s);
        query.setParameter("st","Not Paid");
        List<Reserve> list = query.list();

        transaction.commit();
        session.close();

        return list;
    }

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
    public boolean update(Reserve entity) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
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
