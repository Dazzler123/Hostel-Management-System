package bo.custom.impl;

import bo.custom.UserLoginBO;
import dao.DAOFactory;
import dao.custom.UserCredentialDAO;
import dao.custom.impl.UserCredentialDAOImpl;

public class UserLoginBOImpl implements UserLoginBO {

    //Dependency injection - property injection
    private final UserCredentialDAO credentialDAO = (UserCredentialDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.USER_CREDENTIAL);


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

    public boolean updateCredentials(String username, String newUn, String newPw) {
        return credentialDAO.update(username,newUn,newPw);
    }


}
