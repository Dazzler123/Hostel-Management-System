package bo.custom.impl;

import bo.custom.NewRoomBO;
import dao.custom.RoomDAO;
import dao.custom.impl.RoomDAOImpl;
import dto.RoomDTO;
import entity.Room;

public class NewRoomBOImpl implements NewRoomBO {

    //Dependeny injection - property injection
    RoomDAO roomDAO = new RoomDAOImpl();

    @Override
    public boolean saveRoom(RoomDTO roomDTO) {
        Room room = new Room();
        room.setRoom_id(roomDTO.getRoomID());
        room.setType(roomDTO.getType());
        room.setKey_money(roomDTO.getKeyMoney());
        room.setQty(roomDTO.getQty());

        return roomDAO.save(room);
    }
}
