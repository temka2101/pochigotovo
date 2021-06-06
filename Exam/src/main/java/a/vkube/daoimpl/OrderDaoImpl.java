package a.vkube.daoimpl;

import a.vkube.dao.DAO;
import a.vkube.model.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class OrderDaoImpl implements DAO<Order, Integer> {

    SessionFactory factory;

    public OrderDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Order order) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(order);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Order order) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.update(order);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Order order) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(order);
            session.getTransaction().commit();
        }
    }

    @Override
    public Order findById(Integer id) {
        try (Session session = factory.openSession()){
            return session.get(Order.class, id);
        }
    }

    @Override
    public List<Order> findByAll() {
        try (Session session = factory.openSession()){
            return session.createQuery("FROM Order", Order.class).list();
        }
    }
}