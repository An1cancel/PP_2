package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {

   List<User> listUsers();

   void add(User user , Car car);

   List<User> carUser(String model, int series);
}
