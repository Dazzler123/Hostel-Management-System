package lk.ijse.hms.bo.custom.impl;

import lk.ijse.hms.bo.custom.ManageStudentBO;
import lk.ijse.hms.dao.DAOFactory;
import lk.ijse.hms.dao.custom.StudentDAO;
import lk.ijse.hms.dto.StudentDTO;
import lk.ijse.hms.entity.Student;

import java.util.ArrayList;

public class ManageStudentBOImpl implements ManageStudentBO {

    //Dependency injection - property injection
    private final StudentDAO studentDAO = (StudentDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.STUDENT);

    @Override
    public ArrayList<StudentDTO> loadAll() {
        ArrayList<StudentDTO> students = new ArrayList<>();
        for (Student s : studentDAO.getAll()) {
            students.add(new StudentDTO(s.getStudent_id(), s.getName(), s.getAddress(), s.getContact_no(), s.getDob(), s.getGender()));
        }
        return students;
    }

    @Override
    public StudentDTO searchStudent(String id) {
        StudentDTO studentDTO = null;
        for (Student s : studentDAO.search(id)) {
            studentDTO = new StudentDTO(s.getStudent_id(), s.getName(),
                    s.getAddress(), s.getContact_no(), s.getDob(),
                    s.getGender());
        }
        return studentDTO;
    }

    @Override
    public boolean updateStudentDetails(StudentDTO studentDTO) {
        Student student = new Student();
        student.setStudent_id(studentDTO.getStudentID());
        student.setName(studentDTO.getName());
        student.setAddress(studentDTO.getAddress());
        student.setContact_no(studentDTO.getContactNo());
        student.setDob(studentDTO.getDate());
        student.setGender(studentDTO.getGender());

        return studentDAO.update(student);
    }

    @Override
    public boolean deleteStudent(String id) {
        return studentDAO.delete(id);
    }

}
