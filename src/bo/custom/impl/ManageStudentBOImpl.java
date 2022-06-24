package bo.custom.impl;

import bo.custom.ManageStudentBO;
import dao.custom.StudentDAO;
import dao.custom.impl.StudentDAOImpl;
import dto.StudentDTO;
import entity.Student;

import java.util.ArrayList;

public class ManageStudentBOImpl implements ManageStudentBO {

    //Dependency injection - property injection
    StudentDAO studentDAO = new StudentDAOImpl();
    @Override
    public ArrayList<StudentDTO> loadAll() {
        ArrayList<StudentDTO> students = new ArrayList<>();
        for(Student s : studentDAO.getAll()){
            students.add(new StudentDTO(s.getStudent_id(),s.getName(),s.getAddress(),s.getContact_no(),s.getDob(),s.getGender()));
        }
        return students;
    }
}
