package Hibernate;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Andrew on 26.06.2015.
 */
public interface InterfaceDAO {
    public Dish getDishById(Long bus_id) throws SQLException;

    public Collection getAllDishes() throws SQLException;

    public void addIngridient(Ingridient ingridient) throws SQLException;
}
