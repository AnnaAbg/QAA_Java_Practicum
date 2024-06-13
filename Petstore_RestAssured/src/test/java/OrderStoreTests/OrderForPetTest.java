package OrderStoreTests;

import base.BaseTest;
import dto.data.PetStoreModel;
import dto.response.ErrorResponse;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static utils.StatusCode.STATUS_CODE_ERROR_500;
import static utils.StatusCode.STATUS_CODE_OK;
import static utils.expectedObjectBuilder.ExpectedErrorObjectBuilder.getUnknownErrorResponse;
import static utils.testDataHelper.TestDataStoreHelper.*;
import static utils.testObjectBuilder.TestPetStoreBuilder.getPetStoreModel;

/**
 * This class contains tests for placing orders for pets.
 */

@Epic("Order For Pet")
@Feature("Place Order")
public class OrderForPetTest extends BaseTest {

    @Severity(SeverityLevel.CRITICAL)
    @Story("Place an order for a pet - Happy Path")
    @Description("Check placing an order for a pet in a happy path scenario.")
    @Test
    public void testPlaceAnOrderForPet_HappyPath() {

        step("Create new store model with Valid orderID", () -> {
            storeRequest = getPetStoreModel(VALID_RANDOM_STORE_ID);
        });


        step("Create request with /store/order path", () -> {
            responseWrapper = storeApiRequests.createOrder(storeRequest);

        });

        step(" Check status code and shipDate", () -> {
            int statusCode = responseWrapper.getStatusCode();
            PetStoreModel response = responseWrapper.as(PetStoreModel.class);

            assertSoftly(
                    softAssertions -> {
                        assertThat(statusCode)
                                .withFailMessage("Status code doesn't match")
                                .isEqualTo(STATUS_CODE_OK);
                        assertThat(response.getShipDate())
                                .withFailMessage("ShipDate does not match")
                                .matches(storeRequest.getShipDate().replaceAll("Z$", "(Z|\\\\+0000)"));
                    }
            );
        });
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("Create an invalid order")
    @Description("Check creating an invalid order.")
    @Test
    public void testCreateInvalidOrder() {

        step("Create new store model with Invalid ID", () -> {
            storeRequest = getPetStoreModel(INVALID_ORDER_ID, INVALID_DATE_FORMAT_SHIP_DATE);
        });


        step("Create request with /store/order path", () -> {
            responseWrapper = storeApiRequests.createOrder(storeRequest);

        });

        step("Check status code and error", () -> {
            int statusCode = responseWrapper.getStatusCode();
            ErrorResponse error = responseWrapper.as(ErrorResponse.class);

            assertSoftly(
                    softAssertions -> {
                        assertThat(statusCode)
                                .withFailMessage("Status code doesn't match")
                                .isEqualTo(STATUS_CODE_ERROR_500);
                        assertThat(error)
                                .withFailMessage("ShipDate does not match")
                                .isEqualTo(getUnknownErrorResponse());
                    }
            );
        });
    }


    @Severity(SeverityLevel.NORMAL)
    @Story("Empty ID when creating an order")
    @Description("Check handling empty ID when creating an order.")
    @Test
    public void testEmptyIDWhenCreatingOrder() {

        step("Create new store model with Empty ID", () -> {
            storeRequest = getPetStoreModel(EMPTY_ORDER_ID, INVALID_DATE_FORMAT_SHIP_DATE);
        });


        step("Create request with /store/order path", () -> {
            responseWrapper = storeApiRequests.createOrder(storeRequest);
        });

        step("Check status code and error", () -> {
            int statusCode = responseWrapper.getStatusCode();
            ErrorResponse error = responseWrapper.as(ErrorResponse.class);

            assertSoftly(
                    softAssertions -> {
                        assertThat(statusCode)
                                .withFailMessage("Status code doesn't match")
                                .isEqualTo(STATUS_CODE_ERROR_500);
                        assertThat(error)
                                .withFailMessage("ShipDate does not match")
                                .isEqualTo(getUnknownErrorResponse());
                    }
            );
        });
    }
}