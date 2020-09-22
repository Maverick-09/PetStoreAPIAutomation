package Base;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

import java.util.logging.Logger;

public class TestBase {

    public static String url = "https://petstore.swagger.io/v2/pet";
    public static RequestSpecification request;
    public int id = 123454321;
    public String name = "TRex";
    public Logger logger = Logger.getLogger("PetStore");

    @BeforeClass
    public void initialization(){

        RestAssured.baseURI = url;
        request = RestAssured.given();
        logger.info("Driver Initialized");
    }

}
