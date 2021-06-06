package a.vkube.daoimpl;

import a.vkube.dao.DAO;
import a.vkube.model.DriverLicense;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class DriverLicenseDaoImpl implements DAO<DriverLicense, Integer> {

    SessionFactory factory;

    public DriverLicenseDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(DriverLicense driverLicense) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(driverLicense);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(DriverLicense driverLicense) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.update(driverLicense);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(DriverLicense driverLicense) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(driverLicense);
            session.getTransaction().commit();
        }
    }

    @Override
    public DriverLicense findById(Integer id) {
        try (Session session = factory.openSession()){
            return session.get(DriverLicense.class, id);
        }
    }

    @Override
    public List<DriverLicense> findByAll() {
        try (Session session = factory.openSession()){
            return session.createQuery("FROM DriverLicense", DriverLicense.class).list();
        }
    }
}
