package lk.ijse.hms.bo.custom;

import lk.ijse.hms.bo.SuperBO;
import lk.ijse.hms.dto.ReserveDTO;
import lk.ijse.hms.dto.StudentDTO;

import java.util.ArrayList;

public interface ReportsBO extends SuperBO {
    public ArrayList<ReserveDTO> getReservation();
    public ArrayList<StudentDTO> getStudents(String id);
}
