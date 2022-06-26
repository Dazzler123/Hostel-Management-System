package bo.custom.impl;

import bo.custom.NewRoomBO;
import dao.DAOFactory;
import dao.custom.RoomDAO;
import dto.RoomDTO;
import entity.Room;

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
