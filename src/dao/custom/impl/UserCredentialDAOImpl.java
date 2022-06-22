package dao.custom.impl;

import dao.custom.UserCredentialDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.util.List;

public class UserCredentialDAOImpl implements UserCredentialDAO {
    @Override
    public List<String> getUserName() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT username FROM user_credential");
        List<String> username = query.list();

        transaction.commit();
        session.close();

        return username;
    }

    @Override
    public List<String> getPassWord() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT password FROM user_credential");
        List<String> password = query.list();

        transaction.commit();
        session.close();

        return password;
    }
}
