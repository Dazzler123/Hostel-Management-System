package dao.custom.impl;

import dao.custom.StudentDAO;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public boolean save(Student student) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(student); // save new student

        transaction.commit();
        session.close();
        return true;
    }

    public List<Student> search(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("FROM student WHERE student_id = : id");
        query.setParameter("id",id);
        List<Student> studentId = query.list();

        transaction.commit();
        session.close();

        return studentId;
    }

    //    @Override
//    public List<Student> getName(String id) {
//        Session session = FactoryConfiguration.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//
//        Query sqlQuery = session.createQuery("SELECT name FROM student WHERE student_id= : id");
//        sqlQuery.setParameter("id",id);
//        List<Student> name = sqlQuery.list();
//
//        transaction.commit();
//        session.close();
//
//        return name;
//    }

    @Override
    public Student get(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Student student = session.get(Student.class, id);

        transaction.commit();
        session.close();

        return student;
    }



}
