package a.vkube.daoimpl;

import a.vkube.dao.DAO;
import a.vkube.model.Driver;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class DriverDaoImpl implements DAO<Driver, Integer> {

    SessionFactory factory;

    public DriverDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Driver driver) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(driver);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Driver driver) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.update(driver);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Driver driver) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(driver);
            session.getTransaction().commit();
        }
    }

    @Override
    public Driver findById(Integer id) {
        try (Session session = factory.openSession()){
            return session.get(Driver.class, id);
        }
    }

    @Override
    public List<Driver> findByAll() {
        try (Session session = factory.openSession()){
            return session.createQuery("FROM Driver", Driver.class).list();
        }
    }
}
