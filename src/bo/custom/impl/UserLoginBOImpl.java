package bo.custom.impl;

import bo.custom.UserLoginBO;
import dao.custom.UserCredentialDAO;
import dao.custom.impl.UserCredentialDAOImpl;

public class UserLoginBOImpl implements UserLoginBO {

    //Dependency injection - property injection
    UserCredentialDAO credentialDAO = new UserCredentialDAOImpl();


    @Override
    public String getUserName() {
        String un = null;
        for(String userName : credentialDAO.getUserName()){
            un = userName;
        }
        return un;
    }

    @Override
    public String getPassWord() {
        String pw = null;
        for(String password : credentialDAO.getPassWord()){
            pw = password;
        }
        return pw;
    }

}
