package testgroup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import testgroup.dao.CarDAO;
import testgroup.model.Car;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private CarDAO carDAO;

    @Autowired
    public void setCarDAO(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @Override
    @Transactional
    public List<Car> allCars(int page) {
        return carDAO.allCars(page);
    }

    @Override
    @Transactional
    public void add(Car car) {
        carDAO.add(car);
    }

    @Override
    @Transactional
    public void delete(Car car) {
        carDAO.delete(car);
    }

    @Override
    @Transactional
    public void edit(Car car) {
        carDAO.edit(car);
    }

    @Override
    public Car getById(int id) {
        return carDAO.getById(id);
    }


    @Override
    @Transactional
    public int carsCount() {
        return carDAO.carsCount();
    }

    @Override
    public boolean checkState_Number(String state_number) {
        return carDAO.checkState_Number(state_number);
    }


}
