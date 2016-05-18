package ee.kaarelkivistik.cars;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by kaarel on 18.05.16.
 */

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    CarRepository carRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        log.info("Deleting all cars..");

        carRepository.deleteAll();

        log.info("Creating some cars..");

        carRepository.save(new Car("Volvo", "XC90", 2016, "Damn son, that's a good car."));
        carRepository.save(new Car("Audi", "Q7S", 2015, "Lorem ipsum dolor sit amet."));
        carRepository.save(new Car("BMW", "330XD", 2008, "Bayerische Motoren Werke."));

        log.info("Listing cars:"); log.info("");

        carRepository.findAll().forEach(car -> log.info(car.toString())); log.info("");
    }
}
