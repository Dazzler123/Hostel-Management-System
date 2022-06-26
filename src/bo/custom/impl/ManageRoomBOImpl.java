package bo.custom.impl;

import bo.custom.ManageRoomBO;
import dao.DAOFactory;
import dao.custom.RoomDAO;
import dao.custom.impl.RoomDAOImpl;
import dto.RoomDTO;
import entity.Room;

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
