package OrderStoreTests;

import base.BaseTest;
import dto.data.PetStoreModel;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static utils.StatusCode.STATUS_CODE_OK;
import static utils.testDataHelper.TestDataStoreHelper.VALID_RANDOM_STORE_ID;
import static utils.testObjectBuilder.TestPetStoreBuilder.getPetStoreModel;

/**
 * This class contains tests for getting an order by ID.
 */

@Epic("Get Order By ID")
@Feature("Get Order")
public class GetOrderByIDTest extends BaseTest {

    @Severity(SeverityLevel.NORMAL)
    @Story("Get order by ID - Happy Path")
    @Description("Check getting an order by ID in a happy path scenario.")
    @Test
    public void testGetOrderByID_HappyPath() {

        step("Create store model request with /store/order path", () -> {
            responseWrapper = storeApiRequests.createOrder(storeRequest = getPetStoreModel(VALID_RANDOM_STORE_ID));
        });

        step("Get request orderID with /:orderid path", () -> {
            responseWrapper = storeApiRequests.getOrderById(VALID_RANDOM_STORE_ID);
        });

        step("status code and orderID", () -> {
            int statusCode = responseWrapper.getStatusCode();
            PetStoreModel response = responseWrapper.as(PetStoreModel.class);

            assertSoftly(
                    softAssertions -> {
                        assertThat(statusCode)
                                .withFailMessage("Status code doesn't match")
                                .isEqualTo(STATUS_CODE_OK);
                        assertThat(response.getId())
                                .withFailMessage("Order ID doesn't match")
                                .isEqualTo(storeRequest.getId());
                    }
            );

        });
    }
}
