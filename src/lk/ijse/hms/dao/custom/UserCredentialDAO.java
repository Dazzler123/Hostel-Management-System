package lk.ijse.hms.dao.custom;

import lk.ijse.hms.dao.SuperDAO;

import java.util.List;

public interface UserCredentialDAO extends SuperDAO {
    public List<String> getUserName();
    public List<String> getPassWord();
    public boolean update(String uName, String newUn, String newPw);
}
