package bo.custom;

import dto.ReserveDTO;
import dto.RoomDTO;

import java.util.ArrayList;

public interface ReservationBO {
    public String generateID();
    public ArrayList<RoomDTO> getAllRooms();
    public boolean searchStudent(String id);
//    public ArrayList<String> getStudentName(String id);
    public boolean saveReservation(ReserveDTO reserveDTO);
    public boolean updateRoomQty(String id, int qty);

}
