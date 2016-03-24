package ee.kaarelkivistik.cars;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by kaarel on 24.03.16.
 */
public class CarLogger {

    private Logger logger;

    public CarLogger() throws IOException {
        logger = Logger.getLogger("carLogger");

        FileHandler fileHandler = new FileHandler("log.txt");

        logger.addHandler(fileHandler);
        logger.setUseParentHandlers(false);
    }

    public void log(String message) {
        logger.log(Level.INFO, message);
    }
}
