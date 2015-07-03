package Hibernate;

/**
 * Created by Andrew on 26.06.2015.
 */
public class FactoryDAO {
    static FactoryDAO instance = null;
    static ImplementationDAO implementationDAO = null;

    public static synchronized FactoryDAO getInstance() {
        if (instance == null) {
            instance = new FactoryDAO();
        }
        return instance;
    }

    public ImplementationDAO getImplementationDAO() {
        if (implementationDAO == null) {
            implementationDAO = new ImplementationDAO();
        }
        return implementationDAO;
    }
}
