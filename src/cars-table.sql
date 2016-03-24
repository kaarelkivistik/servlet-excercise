DROP TABLE IF EXISTS cars;
DROP SEQUENCE IF EXISTS car_id;

CREATE SEQUENCE car_id;

CREATE TABLE cars(
  id INT NOT NULL DEFAULT nextval('car_id'),
  brand VARCHAR(20) NOT NULL,
  model VARCHAR(20) NOT NULL,
  year SMALLINT NOT NULL,
  review TEXT NOT NULL
);

INSERT INTO cars (brand, model, year, review) VALUES ('Audi', 'A6', 2006, 'Some rather lengthy text about this car.');
INSERT INTO cars (brand, model, year, review) VALUES ('BMW', '330xd',  2007, 'Some rather lengthy text about this car.');
INSERT INTO cars (brand, model, year, review) VALUES ('Volvo', 'V70', 2009, 'Some rather lengthy text about this car.');