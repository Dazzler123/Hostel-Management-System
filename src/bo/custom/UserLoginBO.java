package bo.custom;

public interface UserLoginBO {
    public String getUserName();
    public String getPassWord();
    public boolean updateCredentials(String username, String newUn, String newPw);
}
