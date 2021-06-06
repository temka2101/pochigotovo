package a.vkube.daoimpl;

import a.vkube.dao.DAO;
import a.vkube.model.DepartureLocation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class DepartureLocationDaoImpl implements DAO<DepartureLocation, Integer> {

    SessionFactory factory;

    public DepartureLocationDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(DepartureLocation departureLocation) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(departureLocation);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(DepartureLocation departureLocation) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.update(departureLocation);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(DepartureLocation departureLocation) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(departureLocation);
            session.getTransaction().commit();
        }
    }

    @Override
    public DepartureLocation findById(Integer id) {
        try (Session session = factory.openSession()){
            return session.get(DepartureLocation.class, id);
        }
    }

    @Override
    public List<DepartureLocation> findByAll() {
        try (Session session = factory.openSession()){
            return session.createQuery("FROM DepartureLocation", DepartureLocation.class).list();
        }
    }
}
