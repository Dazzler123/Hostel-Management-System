package bo.custom;

import bo.SuperBO;

public interface UserLoginBO extends SuperBO {
    public String getUserName();
    public String getPassWord();
    public boolean updateCredentials(String username, String newUn, String newPw);
}
