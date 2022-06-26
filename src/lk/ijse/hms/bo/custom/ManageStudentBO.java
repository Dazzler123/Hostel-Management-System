package lk.ijse.hms.bo.custom;

import lk.ijse.hms.bo.SuperBO;
import lk.ijse.hms.dto.StudentDTO;

import java.util.ArrayList;

public interface ManageStudentBO extends SuperBO {
    public ArrayList<StudentDTO> loadAll();
    public StudentDTO searchStudent(String id);
    public boolean updateStudentDetails(StudentDTO studentDTO);
    public boolean deleteStudent(String id);
}
