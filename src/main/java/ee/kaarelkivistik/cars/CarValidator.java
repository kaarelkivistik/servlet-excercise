package ee.kaarelkivistik.cars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kaarel on 23.03.16.
 */
public class CarValidator {
    public static Map<String, String> validateCarForm(CarForm carForm) {
        Map<String, String> errors = new HashMap<String, String>();

        if (carForm.getBrand() == null) {
            errors.put("brand", "brand cannot be empty");
        } else if(carForm.getBrand().length() > 20) {
            errors.put("brand", "brand name too long");
        }

        if (carForm.getModel() == null) {
            errors.put("model", "model cannot be empty");
        } else if(carForm.getModel().length() > 20) {
            errors.put("model", "model name too long");
        }

        try {
            Integer.parseInt(carForm.getYear());
        } catch(NumberFormatException e) {
            errors.put("year", "year is not in the right format");
        }

        if (carForm.getReview() == null) {
            errors.put("review", "review cannot be empty");
        } else if(carForm.getReview().length() <= 10) {
            errors.put("review", "review too short");
        }

        return errors;
    }
}
