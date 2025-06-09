import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Registration {

    private static final Logger logger = LogManager.getLogger();

    static void Registrations() {
        try {
            int age = 10;
            logger.info("Application started!");
            if(age < 5 || age > 25) {
                logger.warn("5<age<25");
            }
        } catch(Exception e) {
            logger.error(e.getMessage());
        } finally {
            logger.info("Application closed!");
        }
    }

    public static void main(String[] args) {
         Registrations();
    }
}

// In a file upload feature:
// Log start of upload (INFO)
// Log size if file > 50MB (WARN)
// Log I/O errors during upload (ERROR)