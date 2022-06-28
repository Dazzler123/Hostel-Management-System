package lk.ijse.hms.bo.custom.impl;

import lk.ijse.hms.bo.custom.ReportsBO;
import lk.ijse.hms.dao.DAOFactory;
import lk.ijse.hms.dao.custom.QueryDAO;

public class ReportsBOImpl implements ReportsBO {
    //Dependency injection - property injection
    private final QueryDAO queryDAO = (QueryDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.QUERY);

    @Override
    public void getStudents() {

    }
}
