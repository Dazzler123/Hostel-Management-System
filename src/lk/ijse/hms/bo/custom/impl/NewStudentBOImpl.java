package lk.ijse.hms.bo.custom.impl;

import lk.ijse.hms.bo.custom.NewStudentBO;
import lk.ijse.hms.dao.DAOFactory;
import lk.ijse.hms.dao.custom.StudentDAO;
import lk.ijse.hms.dto.StudentDTO;
import lk.ijse.hms.entity.Student;


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
