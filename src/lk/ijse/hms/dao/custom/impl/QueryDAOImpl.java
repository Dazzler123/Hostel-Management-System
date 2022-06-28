package lk.ijse.hms.dao.custom.impl;

import lk.ijse.hms.dao.custom.QueryDAO;
import lk.ijse.hms.entity.Student;
import lk.ijse.hms.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public List<Student> haveNotPaid() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("");
        List<Student> list = query.list();

        transaction.commit();
        session.close();

        return list;
    }
}
