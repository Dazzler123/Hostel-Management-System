package lk.ijse.hms.bo.custom.impl;

import lk.ijse.hms.bo.custom.ManageRoomBO;
import lk.ijse.hms.dao.DAOFactory;
import lk.ijse.hms.dao.custom.RoomDAO;
import lk.ijse.hms.dto.RoomDTO;
import lk.ijse.hms.entity.Room;

import java.util.ArrayList;

public class ManageRoomBOImpl implements ManageRoomBO {

    //Dependency injection - property injection
    private final RoomDAO roomDAO = (RoomDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ROOM);

    @Override
    public ArrayList<RoomDTO> loadAll() {
        ArrayList<RoomDTO> roomList = new ArrayList<>();
        for (Room r : roomDAO.getAll()){
            roomList.add(new RoomDTO(r.getRoom_id(),r.getType(),r.getKey_money(),r.getQty()));
        }
        return roomList;
    }

    @Override
    public RoomDTO getRoom(String id) {
        RoomDTO roomDTO = null;
        for(Room r :  roomDAO.search(id)){
            roomDTO = new RoomDTO(r.getRoom_id(),r.getType(),r.getKey_money(),r.getQty());
        }
        return roomDTO;
    }

    @Override
    public boolean updateRoom(RoomDTO roomDTO) {
        Room room = new Room();
        room.setRoom_id(roomDTO.getRoomID());
        room.setType(roomDTO.getType());
        room.setKey_money(roomDTO.getKeyMoney());
        room.setQty(roomDTO.getQty());

        return roomDAO.update(room);
    }

    public boolean deleteRoom(String id) {
        return roomDAO.delete(id);
    }
}
