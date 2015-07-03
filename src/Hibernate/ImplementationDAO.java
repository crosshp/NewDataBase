package Hibernate;

import org.hibernate.Session;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Andrew on 26.06.2015.
 */
public class ImplementationDAO implements InterfaceDAO{
    @Override
    public Dish getDishById(Long bus_id) throws SQLException {
        Session session = null;
        Dish dish = null;
        try {
            session = HibernateUtill.getSessionFactory().openSession();
            dish = (Dish) session.load(Dish.class, bus_id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "������ 'findById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return dish;
    }

    @Override
    public Collection getAllDishes() throws SQLException {
        Session session = null;
        List dishes = new ArrayList<Dish>();
        try {
            session = HibernateUtill.getSessionFactory().openSession();
            dishes = session.createCriteria(Dish.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "������ 'findById 333'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return dishes;
    }

    @Override
    public void addIngridient(Ingridient ingridient) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtill.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(ingridient);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "������ 'findById 333'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
