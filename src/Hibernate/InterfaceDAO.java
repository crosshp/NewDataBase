package Hibernate;

import org.hibernate.Session;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * Created by Andrew on 26.06.2015.
 */
public interface InterfaceDAO {
    public Dish getDishById(Long bus_id) throws SQLException;

    public Collection getAllDishes() throws SQLException;

    public void addIngridient(Ingridient ingridient) throws SQLException;

    public void addDishAndIngridient(DishAndIngridient dishAndIngridient) throws SQLException;

    public long getLastId() throws SQLException;

    public long getLastIdFromTable(String tableName) throws SQLException;

    public void addDish(Dish dish) throws SQLException;

    public void deleteFromTable(String tableName) throws SQLException;

    public void deleteAndCreateDish() throws SQLException;

    public void updateTest(Tests tests)throws SQLException;

    public void updateDishAndIngridient(DishAndIngridient dishAndIngridient)throws SQLException;

    public Ingridient getIngridientById(long id) throws SQLException;

    public List<Ingridient> getAllIngridients() throws SQLException;
    public List executeQuery(String query);


}
