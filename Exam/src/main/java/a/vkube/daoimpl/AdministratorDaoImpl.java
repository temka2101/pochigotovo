package a.vkube.daoimpl;

import a.vkube.dao.DAO;
import a.vkube.model.Administrator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class AdministratorDaoImpl implements DAO<Administrator, Integer> {

    SessionFactory factory;

    public AdministratorDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Administrator administrator) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(administrator);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Administrator administrator) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.update(administrator);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Administrator administrator) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(administrator);
            session.getTransaction().commit();
        }
    }

    @Override
    public Administrator findById(Integer id) {
        try (Session session = factory.openSession()){
            return session.get(Administrator.class, id);
        }
    }

    @Override
    public List<Administrator> findByAll() {
        try (Session session = factory.openSession()){
            return session.createQuery("FROM Administrator", Administrator.class).list();
        }
    }
}