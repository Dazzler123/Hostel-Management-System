package bo.custom;

import bo.SuperBO;
import dto.StudentDTO;

import java.util.ArrayList;

public interface ManageStudentBO extends SuperBO {
    public ArrayList<StudentDTO> loadAll();
    public StudentDTO searchStudent(String id);
    public boolean updateStudentDetails(StudentDTO studentDTO);
    public boolean deleteStudent(String id);
}
