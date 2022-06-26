package bo.custom.impl;

import bo.custom.NewStudentBO;
import dao.DAOFactory;
import dao.custom.StudentDAO;
import dao.custom.impl.StudentDAOImpl;
import dto.StudentDTO;
import entity.Student;


public class NewStudentBOImpl implements NewStudentBO {

    //Dependency injection - property injection
    private final StudentDAO studentDAO = (StudentDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.STUDENT);

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
