package ee.kaarelkivistik.cars;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Created by kaarel on 18.05.16.
 */

@Controller
@EnableAutoConfiguration
@RequestMapping("ui")
public class CarController {

    private static final Logger log = LoggerFactory.getLogger(CarController.class);

    @Autowired
    CarRepository carRepository;

    @RequestMapping(value = "car", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("car", new Car());

        return "form";
    }

    @RequestMapping(value = "car/{id}", method = RequestMethod.GET)
    public String showFormForCar(@PathVariable Integer id, Model model) {
        Car car = carRepository.findOne(id);

        if(car == null)
            throw new ResourceNotFoundException();

        model.addAttribute("updating", true);
        model.addAttribute("car", car);

        return "form";
    }

    @RequestMapping(value = "car", method = RequestMethod.POST)
    public String saveCar(@ModelAttribute Car car, Model model) {
        try {
            carRepository.save(car);
        } catch (ConstraintViolationException e) {
            model.addAttribute("car", car);

            String[] errors = e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).toArray(String[]::new);

            model.addAttribute("errors", errors);

            return "form";
        }

        return "redirect:/ui/cars";
    }

    @RequestMapping(value = "cars", method = RequestMethod.GET)
    public String showList(Model model) {
        Iterable<Car> cars = carRepository.findAll();

        model.addAttribute("cars", cars);

        return "list";
    }

}
