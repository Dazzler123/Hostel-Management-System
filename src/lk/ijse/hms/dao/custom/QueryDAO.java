package lk.ijse.hms.dao.custom;

import lk.ijse.hms.dao.SuperDAO;
import lk.ijse.hms.entity.Student;

import java.util.List;

public interface QueryDAO extends SuperDAO {
    public List<Student> haveNotPaid();
}
