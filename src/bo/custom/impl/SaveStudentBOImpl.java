package bo.custom.impl;

import bo.custom.SaveStudentBO;
import dao.custom.StudentDAO;
import dao.custom.impl.StudentDAOImpl;
import dto.StudentDTO;
import entity.Student;

public class SaveStudentBOImpl implements SaveStudentBO {

    //Dependency injection - property injection
    private final StudentDAO studentDAO = new StudentDAOImpl();

    @Override
    public boolean saveStudent(StudentDTO studentDTO) {
        return studentDAO.save(new Student(studentDTO.getStudentID(),studentDTO.getName(),
                studentDTO.getAddress(),studentDTO.getContactNo(),studentDTO.getDate(),studentDTO.getGender()));
    }
}
