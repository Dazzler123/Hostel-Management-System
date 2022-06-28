package lk.ijse.hms.bo.custom.impl;

import lk.ijse.hms.bo.custom.ReportsBO;
import lk.ijse.hms.dao.DAOFactory;
import lk.ijse.hms.dao.custom.QueryDAO;
import lk.ijse.hms.dao.custom.ReserveDAO;
import lk.ijse.hms.dao.custom.StudentDAO;
import lk.ijse.hms.dto.ReserveDTO;
import lk.ijse.hms.dto.StudentDTO;
import lk.ijse.hms.entity.Reserve;
import lk.ijse.hms.entity.Student;

import java.util.ArrayList;

public class ReportsBOImpl implements ReportsBO {
    //Dependency injection - property injection
    private final QueryDAO queryDAO = (QueryDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.QUERY);
    private final StudentDAO studentDAO = (StudentDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
    private final ReserveDAO reserveDAO = (ReserveDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.RESERVE);

    @Override
    public ArrayList<ReserveDTO> getReservation() {
        ArrayList<ReserveDTO> reservationList = new ArrayList<>();
        for (Reserve r : reserveDAO.getAll()) {
            reservationList.add(new ReserveDTO(r.getRes_id(),
                    r.getDate(), r.getStudent_id().getStudent_id(), r.getRoom_id().getRoom_id(), r.getStatus()));
        }
        return reservationList;
    }

    @Override
    public ArrayList<StudentDTO> getStudents(String id) {
        ArrayList<StudentDTO> students = new ArrayList<>();
        for (Student s : studentDAO.search(id)) {
            students.add(new StudentDTO(s.getStudent_id(), s.getName(), s.getAddress(), s.getContact_no(), s.getDob(), s.getGender()));
        }
        return students;
    }
}
