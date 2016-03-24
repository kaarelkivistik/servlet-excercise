package ee.kaarelkivistik.cars;

import org.junit.Before;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 * Created by kaarel on 24.03.16.
 */
public class CarDAOTest {

    CarDAO carDAO;
    Random random;

    @Before
    public void setUp() throws Exception {
        carDAO = new CarDAO();
        random = new Random();
    }

    @org.junit.Test
    public void testInsertUpdateAndFindOneById() throws Exception {
        String brand = String.valueOf(random.nextLong());
        String updatedBrand = String.valueOf(random.nextLong());
        String model = String.valueOf(random.nextLong());
        int year = random.nextInt(3000);
        String review = String.valueOf(random.nextLong());

        Car car = new Car(brand, model, year, review);

        car.setId(carDAO.insert(car));

        car.setBrand(updatedBrand);

        carDAO.update(car);

        Car updatedCar = carDAO.findOneById(car.getId());

        assertTrue(updatedCar.equals(car));

        carDAO.delete(car.getId());
    }

    @org.junit.Test
    public void testInsertAndFindAll() throws Exception {
        String brand = String.valueOf(random.nextLong());
        String model = String.valueOf(random.nextLong());
        int year = random.nextInt(3000);
        String review = String.valueOf(random.nextLong());

        int id = carDAO.insert(new Car(brand, model, year, review));

        ArrayList<Car> cars = carDAO.findAll();

        assertTrue(cars.parallelStream().anyMatch(car -> car.getId() == id
                && car.getBrand().equals(brand)
                && car.getModel().equals(model)
                && car.getYear() == year
                && car.getReview().equals(review)));

        carDAO.delete(id);
    }
}