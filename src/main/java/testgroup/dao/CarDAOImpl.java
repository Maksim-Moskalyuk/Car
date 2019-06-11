package testgroup.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import testgroup.model.Car;

import java.util.List;

@Repository
public class CarDAOImpl implements CarDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Car> allCars(int page) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Car").setFirstResult(10 * (page - 1)).setMaxResults(10).list();
    }

    @Override
    public void add(Car car) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(car);
    }

    @Override
    public void delete(Car car) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(car);
    }

    @Override
    public void edit(Car car) {
        Session session = sessionFactory.getCurrentSession();
        session.update(car);
    }

    @Override
    public Car getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Car.class, id);
    }

    @Override
    public int carsCount() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select count(*) from Car", Number.class).getSingleResult().intValue();
    }

    @Override
    public boolean checkState_Number(String state_number) {
        Session session = sessionFactory.getCurrentSession();
        Query query;
        query = session.createQuery("from Car where state_number = :state_number");
        query.setParameter("state_number", state_number);
        return query.list().isEmpty();
    }
}
