package bo;

import bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){

    }

    public static BOFactory getInstance(){
        return boFactory == null ?  boFactory = new BOFactory() : boFactory;
    }

    public enum BOTypes {
        RESERVE, NEW_STUDENT, NEW_ROOM ,MANAGE_STUDENT, MANAGE_ROOM, USER_CREDENTIALS, REPORT
    }

    public SuperBO getBO(BOTypes types) {
        switch (types) {
            case RESERVE:
                return new ReservationBOImpl();
            case NEW_STUDENT:
                return new NewStudentBOImpl();
            case NEW_ROOM:
                return new NewRoomBOImpl();
            case MANAGE_STUDENT:
                return new ManageStudentBOImpl();
            case MANAGE_ROOM:
                return new ManageRoomBOImpl();
            case USER_CREDENTIALS:
                return new UserLoginBOImpl();
            case REPORT:
                return new ReportsBOImpl();
            default:
                return null;
        }
    }

}
