package dto.requests;

import dto.data.PetStoreModel;
import io.restassured.specification.RequestSpecification;
import utils.ResponseWrapper;

import static io.restassured.RestAssured.given;
import static utils.testDataHelper.TestDataStoreHelper.VALID_RANDOM_STORE_ID;

/**
 * Provides methods to perform API requests related to store orders, including creating, retrieving, and deleting orders.
 */
public class StoreApiRequests {

    private final RequestSpecification requestSpecification;

    private static String STORE_ORDER_PATH = "store/order";
    private static final String ID_PARAMETER = "id";

    /**
     * Constructs a new {@code StoreApiRequests} with the specified request specification.
     *
     * @param requestSpecification the request specification to configure the API requests
     */
    public StoreApiRequests(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }


    /**
     * Creates a new store order with the specified details.
     *
     * @param request the details of the order to create
     * @return the response wrapped in a {@link ResponseWrapper}
     */
    public ResponseWrapper createOrder(PetStoreModel request) {
        return new ResponseWrapper(given(requestSpecification)
                .when()
                .body(request)
                .post(STORE_ORDER_PATH)
                .andReturn());
    }

    /**
     * Retrieves an order by its ID.
     *
     * @param orderId the ID of the order to retrieve
     * @return the response wrapped in a {@link ResponseWrapper}
     */
    public ResponseWrapper getOrderById(String orderId) {
        return new ResponseWrapper(given(requestSpecification)
                .when()
                .get(STORE_ORDER_PATH + "/" + VALID_RANDOM_STORE_ID)
                .andReturn());
    }

    /**
     * Deletes an order by its ID.
     *
     * @param orderId the ID of the order to delete
     * @return the response wrapped in a {@link ResponseWrapper}
     */
    public ResponseWrapper deleteOrder(String orderId) {
        return new ResponseWrapper(given(requestSpecification)
                .when()
                //.param(ID_PARAMETER, orderId)
                .delete(STORE_ORDER_PATH + "/" + VALID_RANDOM_STORE_ID)
                .andReturn());
    }

}

