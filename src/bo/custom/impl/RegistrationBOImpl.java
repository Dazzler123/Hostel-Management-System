package bo.custom.impl;

import bo.custom.RegistrationBO;
import dao.custom.RoomDAO;
import dao.custom.StudentDAO;
import dao.custom.impl.RoomDAOImpl;
import dao.custom.impl.StudentDAOImpl;
import dto.RoomDTO;
import entity.Room;
import entity.Student;

import java.util.ArrayList;

public class RegistrationBOImpl implements RegistrationBO {

    //Dependency injection - property injection
    RoomDAO roomDAO = new RoomDAOImpl();
    StudentDAO studentDAO = new StudentDAOImpl();

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


}
