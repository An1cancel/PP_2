package hiber.service;

import hiber.model.Car;
import hiber.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    void add(User user, Car car );

    List<User> carUser(String model, int series);

    List<User> listUsers();
}