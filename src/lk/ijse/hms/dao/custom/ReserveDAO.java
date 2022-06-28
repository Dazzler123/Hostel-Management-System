package lk.ijse.hms.dao.custom;

import lk.ijse.hms.dao.CrudDAO;
import lk.ijse.hms.entity.Reserve;
import lk.ijse.hms.entity.Student;

public interface ReserveDAO extends CrudDAO<Reserve, Student> {
    public boolean save(Reserve reserve);
    public String generateID();
    public boolean updateStatus(String resID, Student student, String status);
}
