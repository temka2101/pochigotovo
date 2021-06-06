package a.vkube.daoimpl;

import a.vkube.dao.DAO;
import a.vkube.model.Status;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class StatusDaoImpl implements DAO<Status, Integer> {

    SessionFactory factory;

    public StatusDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Status status) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(status);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Status status) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.update(status);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Status status) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(status);
            session.getTransaction().commit();
        }
    }

    @Override
    public Status findById(Integer id) {
        try (Session session = factory.openSession()){
            return session.get(Status.class, id);
        }
    }

    @Override
    public List<Status> findByAll() {
        try (Session session = factory.openSession()){
            return session.createQuery("FROM Status", Status.class).list();
        }
    }
}
