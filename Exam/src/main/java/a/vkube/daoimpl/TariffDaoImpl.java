package a.vkube.daoimpl;

import a.vkube.dao.DAO;
import a.vkube.model.Tariff;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class TariffDaoImpl implements DAO<Tariff, Integer> {

    SessionFactory factory;

    public TariffDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Tariff tariff) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(tariff);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Tariff tariff) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.update(tariff);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Tariff tariff) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(tariff);
            session.getTransaction().commit();
        }
    }

    @Override
    public Tariff findById(Integer id) {
        try (Session session = factory.openSession()){
            return session.get(Tariff.class, id);
        }
    }

    @Override
    public List<Tariff> findByAll() {
        try (Session session = factory.openSession()){
            return session.createQuery("FROM Tariff", Tariff.class).list();
        }
    }
}