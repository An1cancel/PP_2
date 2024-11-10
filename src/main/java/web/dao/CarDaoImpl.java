package web.dao;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
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
        if (count == null || count >=carList.size()){
            return carList;
        }else {
            return carList.subList(0, count);
        }
    }
}
