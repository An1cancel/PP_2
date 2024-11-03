package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {


    private SessionFactory sessionFactory;

    @Autowired
    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(User user, Car car) {
        sessionFactory.getCurrentSession().save(user);
        sessionFactory.getCurrentSession().save(car);
        user.setCarId(car);

    }

    @Override
    public List<User> getUserByCar(String model, int series) {
        TypedQuery<User> query = sessionFactory.getCurrentSession()
                .createQuery("FROM User u JOIN FETCH u.carId c WHERE c.model = :model AND c.series = :series", User.class);
        query.setParameter("model", model);
        query.setParameter("series", series);
        return query.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("FROM User u JOIN FETCH u.carId");
        return query.getResultList();
    }

}
