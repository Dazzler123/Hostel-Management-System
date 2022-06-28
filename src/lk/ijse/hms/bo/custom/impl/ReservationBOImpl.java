package lk.ijse.hms.bo.custom.impl;

import lk.ijse.hms.bo.custom.ReservationBO;
import lk.ijse.hms.dao.DAOFactory;
import lk.ijse.hms.dao.custom.ReserveDAO;
import lk.ijse.hms.dao.custom.RoomDAO;
import lk.ijse.hms.dao.custom.StudentDAO;
import lk.ijse.hms.dto.ReserveDTO;
import lk.ijse.hms.dto.RoomDTO;
import lk.ijse.hms.entity.Reserve;
import lk.ijse.hms.entity.Room;
import lk.ijse.hms.entity.Student;

import java.util.ArrayList;

public class ReservationBOImpl implements ReservationBO {

    //Dependency injection - property injection
    RoomDAO roomDAO = (RoomDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ROOM);
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
    ReserveDAO reserveDAO = (ReserveDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.RESERVE);

    @Override
    public String generateID() {
        return reserveDAO.generateID();
    }

    @Override
    public ArrayList<RoomDTO> getAllRooms() {
        ArrayList<RoomDTO> roomList = new ArrayList<>();
        for (Room room : roomDAO.getAll()) {
            roomList.add(new RoomDTO(room.getRoom_id(), room.getType(), room.getKey_money(), room.getQty()));
        }
        return roomList;
    }

    public boolean searchStudent(String id) {
        ArrayList<String> studentIdList = new ArrayList<>();
        for (Student ids : studentDAO.search(id)) {
            studentIdList.add(ids.getStudent_id());
        }
        if (!studentIdList.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    //    @Override
//    public ArrayList<String> getStudentName(String id) {
//        ArrayList<String> studentDTOS = new ArrayList<>();
//        for (Student student : studentDAO.getName(id)) {
//            studentDTOS.add(student.getName());
//        }
//        return studentDTOS;
//    }
    @Override
    public boolean saveReservation(ReserveDTO reserveDTO) {
        Student student = studentDAO.get(reserveDTO.getStudentID());
        Room room = roomDAO.get(reserveDTO.getRoomTypeID());

        return reserveDAO.save(new Reserve(reserveDTO.getResID(), student,
                room, reserveDTO.getDate(), reserveDTO.getStatus()));
    }

    public boolean updateRoomQty(String id, String qty) {
        int convert = Integer.parseInt(qty);
        //remove one room
        int newQty = convert - 1;
        String QTY = String.valueOf(newQty);
        return roomDAO.updateQty(id, QTY);
    }

    @Override
    public void getReservations() {
    }

    @Override
    public void updatePaidStatus() {

    }

}
