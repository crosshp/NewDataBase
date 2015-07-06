package Hibernate;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.hibernate.transform.Transformers;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.swing.*;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by Andrew on 26.06.2015.
 */
public class ImplementationDAO implements InterfaceDAO {
    @Override
    public Dish getDishById(Long bus_id) throws SQLException {
        Session session = null;
        Dish dish = null;
        try {
            session = HibernateUtill.getSessionFactory().openSession();
            dish = (Dish) session.load(Dish.class, bus_id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "1 'findById'", JOptionPane.OK_OPTION);
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
            JOptionPane.showMessageDialog(null, e.getMessage(), "2 'findById 333'", JOptionPane.OK_OPTION);
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
            JOptionPane.showMessageDialog(null, e.getMessage(), "3 'findById 333'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void addDishAndIngridient(DishAndIngridient dishAndIngridient) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtill.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(dishAndIngridient);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "4 'findById 333'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void addDish(Dish dish) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtill.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(dish);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "5 'findById 333'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public long getLastId() throws SQLException {
        Session session = null;
        long lastId = -1;
        try {
            session = HibernateUtill.getSessionFactory().openSession();
            lastId = ((BigInteger) session.createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult()).longValue();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "6'findById 333'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return lastId;
    }

    @Override
    public long getLastIdFromTable(String tableName) throws SQLException {
        Session session = null;
        long lastId = -1;
        try {
            session = HibernateUtill.getSessionFactory().openSession();
            lastId = (new BigInteger(session.createSQLQuery("SELECT MAX(id) FROM " + tableName).uniqueResult().toString())).longValue();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "7 'findById 333'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return lastId;
    }

    @Override
    public void deleteFromTable(String tableName) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtill.getSessionFactory().openSession();
            session.beginTransaction();
            session.createSQLQuery("TRUNCATE TABLE " + tableName).executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "8 'findById 333'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void deleteAndCreateDish() throws SQLException {

        Session session = null;
        try {
            session = HibernateUtill.getSessionFactory().openSession();
            session.beginTransaction();
            // session.createSQLQuery("DROP TABLE " + "dish").executeUpdate();
            //  session.createSQLQuery("CREATE TABLE table.dish ('id' INT NOT NULL AUTO_INCREMENT,'name' VARCHAR(70) NULL,'href' VARCHAR(70) NULL, PRIMARY KEY ('id'))");
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "8 'findById 333'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void updateTest(Tests tests) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtill.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(tests);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void updateDishAndIngridient(DishAndIngridient dishAndIngridient) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtill.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(dishAndIngridient);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }


    public Ingridient getIngridientById(long id) throws SQLException{
        Session session = null;
        Ingridient stud = null;
        try {
            session = HibernateUtill.getSessionFactory().openSession();
            stud = (Ingridient) session.load(Ingridient.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return stud;
    }

    public List<Ingridient> getAllIngridients() throws SQLException{
        Session session = null;
        List<Ingridient> list = null;
        try {
            session = HibernateUtill.getSessionFactory().openSession();
            list = (List<Ingridient>) session.createCriteria(Ingridient.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return list;
    }

    @Override
    public List<Ingridient> executeQuery(String query){
        Session session = null;
        List<Ingridient> aliasToValueMapList = null;
        try {
            session = HibernateUtill.getSessionFactory().openSession();
            session.beginTransaction();
            SQLQuery query1 = session.createSQLQuery(query);
            query1.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
            aliasToValueMapList= query1.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return aliasToValueMapList;
    }



}
