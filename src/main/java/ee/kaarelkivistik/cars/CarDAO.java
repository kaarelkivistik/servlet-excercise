package ee.kaarelkivistik.cars;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by kaarel on 23.03.16.
 */
public class CarDAO {


    public static final String DB_URL = "jdbc:postgresql://192.168.99.100:5432/postgres?user=postgres";

    private Connection connection;

    public CarDAO() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Car> findAll() throws SQLException {
        ArrayList<Car> cars = new ArrayList<Car>();

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM cars");

        ResultSet resultSet = statement.executeQuery();

        while(resultSet.next()) {
            cars.add(new Car(resultSet));
        }

        return cars;
    }

    public Car findOneById(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM cars WHERE cars.id = ? LIMIT 1");
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        resultSet.next();

        return new Car(resultSet);
    }

    public void update(Car car) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("UPDATE cars SET brand = ?, model = ?, year = ?, review = ? WHERE id = ?");

        statement.setInt(5, car.getId());

        statement.setString(1, car.getBrand());
        statement.setString(2, car.getModel());
        statement.setInt(3, car.getYear());
        statement.setString(4, car.getReview());

        statement.executeUpdate();
    }

    public int insert(Car car) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO cars (brand, model, year, review) values(?, ?, ?, ?) RETURNING id");

        statement.setString(1, car.getBrand());
        statement.setString(2, car.getModel());
        statement.setInt(3, car.getYear());
        statement.setString(4, car.getReview());

        ResultSet resultSet = statement.executeQuery();

        resultSet.next();

        return resultSet.getInt(1);
    }

    public void delete(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM cars where id = ?");

        statement.setInt(1, id);

        statement.executeUpdate();
    }
}
