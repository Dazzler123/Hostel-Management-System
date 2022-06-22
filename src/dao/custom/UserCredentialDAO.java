package dao.custom;

import java.util.List;

public interface UserCredentialDAO {
    public List<String> getUserName();
    public List<String> getPassWord();
    public void update();
}
