package dao.custom;

import entity.Reserve;

public interface ReserveDAO {
    public boolean save(Reserve reserve);
    public String generateID();
}
