package bo.custom;

import dto.ReserveDTO;
import dto.RoomDTO;

import java.util.ArrayList;

public interface RegistrationBO {
    public String generateID();
    public ArrayList<RoomDTO> getAllRooms();
    public boolean searchStudent(String id);
//    public ArrayList<String> getStudentName(String id);
    public boolean register(ReserveDTO reserveDTO);

}
