package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao{

    private List<Car> carList = new ArrayList<Car>();

    public CarDaoImpl() {
        carList.add(new Car("Toyota", "Corolla", 2020));
        carList.add(new Car("Honda", "Civic", 2019));
        carList.add(new Car("Ford", "Focus", 2018));
        carList.add(new Car("Chevrolet", "Cruze", 2017));
        carList.add(new Car("BMW", "3 Series", 2016));
    }
    @Override
    public List<Car> getCarList(Integer count) {
        count = (count == null || count > 5) ? 5 : count < 0 ? 0 : count;
        return carList.stream().limit(count).toList();
    }
}
