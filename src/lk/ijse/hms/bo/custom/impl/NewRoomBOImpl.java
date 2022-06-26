package lk.ijse.hms.bo.custom.impl;

import lk.ijse.hms.bo.custom.NewRoomBO;
import lk.ijse.hms.dao.DAOFactory;
import lk.ijse.hms.dao.custom.RoomDAO;
import lk.ijse.hms.dto.RoomDTO;
import lk.ijse.hms.entity.Room;

public class NewRoomBOImpl implements NewRoomBO {

    //Dependency injection - property injection
    private final RoomDAO roomDAO = (RoomDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ROOM);

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
