package bo.custom;

import dto.RoomDTO;

import java.util.ArrayList;

public interface RegistrationBO {
    public ArrayList<RoomDTO> getAllRooms();
    public boolean searchStudent(String id);
//    public ArrayList<String> getStudentName(String id);

}
