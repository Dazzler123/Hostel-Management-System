package lk.ijse.hms.bo.custom.impl;

import lk.ijse.hms.bo.custom.ReportsBO;
import lk.ijse.hms.dao.DAOFactory;
import lk.ijse.hms.dao.custom.QueryDAO;
import lk.ijse.hms.dao.custom.StudentDAO;
import lk.ijse.hms.dto.StudentDTO;
import lk.ijse.hms.entity.Student;

import java.util.ArrayList;

public class ReportsBOImpl implements ReportsBO {
    //Dependency injection - property injection
    private final QueryDAO queryDAO = (QueryDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.QUERY);
    private final StudentDAO studentDAO = (StudentDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.STUDENT);

    @Override
    public ArrayList<StudentDTO> getStudents(String id) {
        ArrayList<StudentDTO> students = new ArrayList<>();
        for(Student s : studentDAO.search(id)){
            students.add(new StudentDTO(s.getStudent_id(),s.getName(),s.getAddress(),s.getContact_no(),s.getDob(),s.getGender()));
        }
        return students;
    }
}
