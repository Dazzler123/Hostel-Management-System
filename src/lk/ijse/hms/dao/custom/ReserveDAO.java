package lk.ijse.hms.dao.custom;

import lk.ijse.hms.dao.CrudDAO;
import lk.ijse.hms.entity.Reserve;

public interface ReserveDAO extends CrudDAO<Reserve,String> {
    public boolean save(Reserve reserve);
    public String generateID();
}
