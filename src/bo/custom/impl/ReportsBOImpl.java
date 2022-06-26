package bo.custom.impl;

import bo.custom.ReportsBO;
import dao.DAOFactory;
import dao.custom.QueryDAO;

public class ReportsBOImpl implements ReportsBO {
    //Dependency injection - property injection
    private final QueryDAO queryDAO = (QueryDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.QUERY);
}
