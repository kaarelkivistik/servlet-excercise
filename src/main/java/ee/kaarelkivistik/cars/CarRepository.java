package ee.kaarelkivistik.cars;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kaarel on 18.05.16.
 */

@Repository
public interface CarRepository extends PagingAndSortingRepository<Car, Integer> {

}
