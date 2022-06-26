package lk.ijse.hms.dao.custom;

import lk.ijse.hms.dao.CrudDAO;
import lk.ijse.hms.entity.Student;

import java.util.List;

public interface StudentDAO extends CrudDAO<Student,String> {
    public boolean save(Student student);
    public List<Student> search(String id);
    //public List<Student> getName(String id);
    public Student get(String id);
    public List<Student> getAll();
    public boolean update(Student student);
    public boolean delete(String id);
}
