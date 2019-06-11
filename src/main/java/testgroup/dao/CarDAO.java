package testgroup.dao;

import testgroup.model.Car;

import java.util.List;

public interface CarDAO {
    List<Car> allCars(int page);
    void add(Car car);
    void delete(Car car);
    void edit(Car car);
    Car getById(int id);

    int carsCount();

    boolean checkState_Number(String state_number);
}