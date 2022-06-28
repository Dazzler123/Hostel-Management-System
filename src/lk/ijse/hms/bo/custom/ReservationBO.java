package lk.ijse.hms.bo.custom;

import lk.ijse.hms.bo.SuperBO;
import lk.ijse.hms.dto.ReserveDTO;
import lk.ijse.hms.dto.RoomDTO;

import java.util.ArrayList;

public interface ReservationBO extends SuperBO {
    public String generateID();
    public ArrayList<RoomDTO> getAllRooms();
    public boolean searchStudent(String id);
//    public ArrayList<String> getStudentName(String id);
    public boolean saveReservation(ReserveDTO reserveDTO);
    public boolean updateRoomQty(String id, String qty);
    public ArrayList<ReserveDTO> getReservations(String id);
    public void updatePaidStatus();
}
