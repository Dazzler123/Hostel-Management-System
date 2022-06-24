package dao.custom;

import entity.Student;

import java.util.List;

public interface StudentDAO {
    public boolean save(Student student);
    public List<Student> search(String id);
    //public List<Student> getName(String id);
    public Student get(String id);
    public List<Student> getAll();

}
