package lk.ijse.hms.bo.custom;

import lk.ijse.hms.bo.SuperBO;
import lk.ijse.hms.dto.StudentDTO;

public interface NewStudentBO extends SuperBO {
    public boolean saveStudent(StudentDTO studentDTO);
}
