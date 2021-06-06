package a.vkube.daoimpl;

import a.vkube.dao.DAO;
import a.vkube.model.DestinationLocation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class DestinationLocationDaoImpl implements DAO<DestinationLocation, Integer> {

    SessionFactory factory;

    public DestinationLocationDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(DestinationLocation destinationLocation) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(destinationLocation);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(DestinationLocation destinationLocation) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.update(destinationLocation);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(DestinationLocation destinationLocation) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(destinationLocation);
            session.getTransaction().commit();
        }
    }

    @Override
    public DestinationLocation findById(Integer id) {
        try (Session session = factory.openSession()){
            return session.get(DestinationLocation.class, id);
        }
    }

    @Override
    public List<DestinationLocation> findByAll() {
        try (Session session = factory.openSession()){
            return session.createQuery("FROM DestinationLocation", DestinationLocation.class).list();
        }
    }
}