package ee.kaarelkivistik.cars;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by kaarel on 23.03.16.
 */
public class Car {
    private int id;
    private String brand;
    private String model;
    private int year;
    private String review;

    public Car(String brand, String model, int year, String review) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.review = review;
    }

    public Car(int id, String brand, String model, int year, String review) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.review = review;
    }

    public Car(String id, String brand, String model, String year, String review) {
        this.id = Integer.parseInt(id);
        this.brand = brand;
        this.model = model;
        this.year = Integer.parseInt(year);
        this.review = review;
    }

    public Car(ResultSet resultSet) throws SQLException {
        id = resultSet.getInt("id");
        brand = resultSet.getString("brand");
        model = resultSet.getString("model");
        year = resultSet.getInt("year");
        review = resultSet.getString("review");
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (id != car.id) return false;
        if (year != car.year) return false;
        if (!brand.equals(car.brand)) return false;
        if (!model.equals(car.model)) return false;
        return review.equals(car.review);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + brand.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + year;
        result = 31 * result + review.hashCode();
        return result;
    }
}
