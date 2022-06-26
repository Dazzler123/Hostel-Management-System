package bo.custom;

import bo.SuperBO;
import dto.StudentDTO;

public interface NewStudentBO extends SuperBO {
    public boolean saveStudent(StudentDTO studentDTO);
}
