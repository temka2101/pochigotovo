package a.vkube.daoimpl;

import a.vkube.dao.DAO;
import a.vkube.model.Passport;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class PassportDaoImpl implements DAO<Passport, Integer> {

    SessionFactory factory;

    public PassportDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Passport passport) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(passport);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Passport passport) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.update(passport);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Passport passport) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(passport);
            session.getTransaction().commit();
        }
    }

    @Override
    public Passport findById(Integer id) {
        try (Session session = factory.openSession()){
            return session.get(Passport.class, id);
        }
    }

    @Override
    public List<Passport> findByAll() {
        try (Session session = factory.openSession()){
            return session.createQuery("FROM Passport", Passport.class).list();
        }
    }
}
