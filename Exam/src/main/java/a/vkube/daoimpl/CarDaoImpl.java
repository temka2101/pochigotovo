package a.vkube.daoimpl;

import a.vkube.dao.DAO;
import a.vkube.model.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CarDaoImpl implements DAO<Car, Integer> {

    SessionFactory factory;

    public CarDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Car car) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(car);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Car car) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.update(car);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Car car) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(car);
            session.getTransaction().commit();
        }
    }

    @Override
    public Car findById(Integer id) {
        try (Session session = factory.openSession()){
            return session.get(Car.class, id);
        }
    }

    @Override
    public List<Car> findByAll() {
        try (Session session = factory.openSession()){
            return session.createQuery("FROM Car", Car.class).list();
        }
    }
}