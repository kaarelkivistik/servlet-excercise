package ee.kaarelkivistik.cars;

/**
 * Created by kaarel on 23.03.16.
 */
public class CarForm {
    private String id;
    private String brand;
    private String model;
    private String year;
    private String review;

    public CarForm(String id, String brand, String model, String year, String review) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.review = review;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
