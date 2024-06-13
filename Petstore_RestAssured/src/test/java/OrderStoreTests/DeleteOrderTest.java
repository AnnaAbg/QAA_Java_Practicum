package OrderStoreTests;

import base.BaseTest;
import dto.response.APIResponse;
import dto.response.ErrorResponse;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static utils.StatusCode.STATUS_CODE_ERROR_404;
import static utils.StatusCode.STATUS_CODE_OK;
import static utils.expectedObjectBuilder.ExpectedErrorObjectBuilder.getNotFound;
import static utils.expectedObjectBuilder.ExpectedObjectBuilder.getDeleteResponse;
import static utils.testDataHelper.TestDataStoreHelper.VALID_RANDOM_STORE_ID;
import static utils.testObjectBuilder.TestPetStoreBuilder.getPetStoreModel;

/**
 * This class contains tests for deleting orders.
 */

@Epic("Delete Order")
@Feature(" Delete Order")
public class DeleteOrderTest extends BaseTest {

    @Severity(SeverityLevel.NORMAL)
    @Story("Delete order by ID")
    @Description("Check deleting an order by ID.")
    @Test
    public void testDeleteOrderByID() {

        step("Create store model request with /store/order path", () -> {
            responseWrapper = storeApiRequests.createOrder(storeRequest = getPetStoreModel(VALID_RANDOM_STORE_ID));
        });

        step("Delete order request with /:orderID path", () -> {
            responseWrapper = storeApiRequests.deleteOrder(VALID_RANDOM_STORE_ID);
        });

        step("Check response and status code", () -> {
            int statusCode = responseWrapper.getStatusCode();
            APIResponse apiResponse = responseWrapper.as(APIResponse.class);


            assertSoftly(
                    softAssertions -> {
                        assertThat(statusCode)
                                .withFailMessage("Status code doesn't match")
                                .isEqualTo(STATUS_CODE_OK);
                        assertThat(apiResponse)
                                .withFailMessage("Response body doesn't match")
                                .isEqualTo(getDeleteResponse());
                    }
            );
        });
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("Check non-existing order ID")
    @Description("Check handling a non-existing order ID.")
    @Test
    public void getCheckNonExistingOrderID() {

        step("Create store model request with /store/order path", () -> {
            responseWrapper = storeApiRequests.createOrder(storeRequest = getPetStoreModel(VALID_RANDOM_STORE_ID));
        });

        step("Delete order request with /:orderID path", () -> {
            responseWrapper = storeApiRequests.deleteOrder(VALID_RANDOM_STORE_ID);
        });

        step("Get request orderID with /:orderid path", () -> {
            responseWrapper = storeApiRequests.getOrderById(VALID_RANDOM_STORE_ID);
        });

        step("Check status code and error", () -> {
            int statusCode = responseWrapper.getStatusCode();
            ErrorResponse error = responseWrapper.as(ErrorResponse.class);

            assertSoftly(
                    softAssertions -> {
                        softAssertions
                                .assertThat(statusCode)
                                .withFailMessage("Status code doesn't match")
                                .isEqualTo(STATUS_CODE_ERROR_404);
                        softAssertions
                                .assertThat(error)
                                .withFailMessage("Error body doesn't match")
                                .isEqualTo(getNotFound());
                    }
            );
        });
    }
}