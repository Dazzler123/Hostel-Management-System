package bo.custom;

import dto.StudentDTO;

import java.util.ArrayList;

public interface ManageStudentBO {
    public ArrayList<StudentDTO> loadAll();
    public StudentDTO searchStudent(String id);
    public boolean updateStudentDetails(StudentDTO studentDTO);
}
