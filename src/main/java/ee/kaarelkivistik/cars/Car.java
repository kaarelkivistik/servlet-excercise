package ee.kaarelkivistik.cars;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.annotation.Nullable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by kaarel on 23.03.16.
 */

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Length(min = 3, max = 20, message = "Brand name length must be between 3 and 20 characters.")
    private String brand;

    private String model;

    @NotNull
    @Range(min = 2000, max = 2016, message = "Year must be between 2000 and 2016.")
    private int year;

    @NotNull
    @Length(min = 10, message = "Review must be at least 10 characters long.")
    private String review;

    protected Car() {}

    public Car(String brand, String model, int year, String review) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.review = review;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", review='" + review + '\'' +
                '}';
    }
}
