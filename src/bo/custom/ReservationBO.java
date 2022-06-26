package bo.custom;

import bo.SuperBO;
import dto.ReserveDTO;
import dto.RoomDTO;

import java.util.ArrayList;

public interface ReservationBO extends SuperBO {
    public String generateID();
    public ArrayList<RoomDTO> getAllRooms();
    public boolean searchStudent(String id);
//    public ArrayList<String> getStudentName(String id);
    public boolean saveReservation(ReserveDTO reserveDTO);
    public boolean updateRoomQty(String id, String qty);

}
