package base;

import config.BaseConfig;
import dto.data.PetModel;
import dto.data.PetStoreModel;
import dto.requests.PetApiRequests;
import dto.requests.StoreApiRequests;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigFactory;
import utils.ResponseWrapper;

/**
 * Base test class providing common setup for API test cases.
 *
 * <p>This class provides common setup methods for API test cases,
 * such as initializing request specifications and API request objects.</p>
 *
 */
public abstract class BaseTest {

    /**
     * Configuration instance for accessing environment variables.
     */
    private final BaseConfig config = ConfigFactory.create(BaseConfig.class, System.getenv());

    /**
     * API request object for pet-related operations.
     */
    protected final PetApiRequests petApiRequests = new PetApiRequests(getRequestSpecification());

    /**
     * API request object for store-related operations.
     */
    protected final StoreApiRequests storeApiRequests = new StoreApiRequests(getRequestSpecification());

    /**
     * PetModel instance for holding pet request data.
     */
    protected PetModel petRequest;

    /**
     * PetStoreModel instance for holding store request data.
     */
    protected PetStoreModel storeRequest;

    /**
     * ResponseWrapper instance for holding API response data.
     */
    protected ResponseWrapper responseWrapper;

    /**
     * Creates and returns a request specification with common settings.
     *
     * @return a RequestSpecification object with common settings
     */
    private RequestSpecification getRequestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(config.baseUrl())
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .addFilter(new AllureRestAssured())
                .log(LogDetail.ALL)
                .build();

    }
}