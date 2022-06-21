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
        Student student = new Student();
        student.setStudent_id(studentDTO.getStudentID());
        student.setName(studentDTO.getName());
        student.setAddress(studentDTO.getAddress());
        student.setContact_no(studentDTO.getContactNo());
        student.setDob(studentDTO.getDate());
        student.setGender(studentDTO.getGender());

        return studentDAO.save(student);
    }
}
