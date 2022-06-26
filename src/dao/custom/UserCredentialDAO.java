package dao.custom;

import dao.CrudDAO;
import dao.SuperDAO;
import entity.UserCredential;

import java.util.List;

public interface UserCredentialDAO extends SuperDAO {
    public List<String> getUserName();
    public List<String> getPassWord();
    public boolean update(String uName, String newUn, String newPw);
}
