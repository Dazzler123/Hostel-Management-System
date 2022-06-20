package bo;

import dao.StudentDAO;
import dao.StudentDAOImpl;
import dto.StudentDTO;

public class SaveStudentBOImpl implements SaveStudentBO{

    //Dependency injection - property injection
    private final StudentDAO studentDAO = new StudentDAOImpl();

    @Override
    public boolean saveStudent(StudentDTO studentDTO) {

        return false;
    }
}
