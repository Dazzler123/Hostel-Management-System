package bo.custom.impl;

import bo.custom.RegistrationBO;
import dao.custom.RoomDAO;
import dao.custom.impl.RoomDAOImpl;
import dto.RoomDTO;
import entity.Room;

import java.util.ArrayList;

public class RegistrationBOImpl implements RegistrationBO {

    //Dependency injection - property injection
    RoomDAO roomDAO = new RoomDAOImpl();

    @Override
    public ArrayList<RoomDTO> getAllRooms() {
        ArrayList<RoomDTO> roomList = new ArrayList<>();
        for (Room room : roomDAO.getAll()) {
                roomList.add(new RoomDTO(room.getRoom_id(),room.getType(),room.getKey_money(),room.getQty()));
        }
        return roomList;
    }
}
