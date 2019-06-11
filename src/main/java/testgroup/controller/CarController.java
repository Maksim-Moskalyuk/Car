package testgroup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import testgroup.model.Car;
import testgroup.service.CarService;

import java.util.List;

@Controller
public class CarController {
    private int page;

    private CarService carService;

    @Autowired
    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allCars(@RequestParam(defaultValue = "1") int page) {
        List<Car> cars = carService.allCars(page);
        int carsCount = carService.carsCount();
        int pagesCount = (carsCount + 9)/10;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cars");
        modelAndView.addObject("page", page);
        modelAndView.addObject("carsList", cars);
        modelAndView.addObject("carsCount", carsCount);
        modelAndView.addObject("pagesCount", pagesCount);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") int id) {
        Car car = carService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("car", car);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editCar(@ModelAttribute("car") Car car) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        carService.edit(car);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage(@ModelAttribute("message") String message) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addCar(@ModelAttribute("car") Car car) {
        ModelAndView modelAndView = new ModelAndView();
        if (carService.checkState_Number(car.getState_number())) {
            modelAndView.setViewName("redirect:/");
            modelAndView.addObject("page", page);
            carService.add(car);
        } else {
            modelAndView.addObject("message","part with state_number \"" + car.getState_number() + "\" already exists");
            modelAndView.setViewName("redirect:/add");
        }
        return modelAndView;
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteCar(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        Car car = carService.getById(id);
        carService.delete(car);
        return modelAndView;
    }
}
