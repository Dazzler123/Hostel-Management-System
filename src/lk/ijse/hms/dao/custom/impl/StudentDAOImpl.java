package lk.ijse.hms.dao.custom.impl;

import lk.ijse.hms.dao.custom.StudentDAO;
import lk.ijse.hms.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import lk.ijse.hms.util.FactoryConfiguration;

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
        query.setParameter("id", id);
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

    @Override
    public List<Student> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("FROM student");
        List<Student> studentList = query.list();

        transaction.commit();
        session.close();

        return studentList;
    }

    @Override
    public boolean update(Student student) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("UPDATE student SET name= : st_name , address = : st_address , contact_no = : st_contactNo , " +
                "dob = : st_dob , gender = : st_gender WHERE student_id = : st_id");
        query.setParameter("st_name", student.getName());
        query.setParameter("st_address", student.getAddress());
        query.setParameter("st_contactNo", student.getContact_no());
        query.setParameter("st_dob", student.getDob());
        query.setParameter("st_gender", student.getGender());
        query.setParameter("st_id", student.getStudent_id());
        int isUpdated = query.executeUpdate();

        transaction.commit();
        session.close();

        if (isUpdated > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Student student = session.get(Student.class, id);

        Query query = session.createQuery("DELETE FROM Reserve WHERE student_id = : s");
        query.setParameter("s", student);
        int isDetached = query.executeUpdate();

        Query query1 = session.createQuery("DELETE FROM student WHERE student_id = : id");
        query1.setParameter("id", id);
        int isDeleted = query1.executeUpdate();

        transaction.commit();
        session.close();

        if (isDeleted > 0) {
            if (isDetached > 0) {
                return true;
            }
            return true;
        }
        return false;
    }


}
