package a.vkube.daoimpl;

import a.vkube.dao.DAO;
import a.vkube.model.Dispather;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class DispatherDaoImpl implements DAO<Dispather, Integer> {

    SessionFactory factory;

    public DispatherDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Dispather dispather) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(dispather);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Dispather dispather) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.update(dispather);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Dispather dispather) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(dispather);
            session.getTransaction().commit();
        }
    }

    @Override
    public Dispather findById(Integer id) {
        try (Session session = factory.openSession()){
            return session.get(Dispather.class, id);
        }
    }

    @Override
    public List<Dispather> findByAll() {
        try (Session session = factory.openSession()){
            return session.createQuery("FROM Dispather", Dispather.class).list();
        }
    }
}