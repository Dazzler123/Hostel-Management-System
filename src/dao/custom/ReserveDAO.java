package dao.custom;

import dao.CrudDAO;
import entity.Reserve;

public interface ReserveDAO extends CrudDAO<Reserve,String> {
    public boolean save(Reserve reserve);
    public String generateID();
}
