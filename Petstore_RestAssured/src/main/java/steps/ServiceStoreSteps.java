package steps;

import dto.data.PetStoreModel;
import dto.requests.StoreApiRequests;
import io.qameta.allure.Step;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import utils.ResponseWrapper;

import static io.qameta.allure.Allure.step;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static utils.testDataHelper.TestDataStoreHelper.VALID_RANDOM_STORE_ID;
import static utils.testObjectBuilder.TestPetStoreBuilder.getPetStoreModel;

public class ServiceStoreSteps extends StoreApiRequests {

    public ServiceStoreSteps(RequestSpecification requestSpecification) {
        super(requestSpecification);
    }

    // 1. Option
    public void createNewStoreModel() {
        step("Create new store model request with {/store/order} path and valid orderID", () -> {
            PetStoreModel storeRequest = getPetStoreModel(VALID_RANDOM_STORE_ID);
            ResponseWrapper responseWrapper = createOrder(storeRequest);
            checkStatusResponse(HttpStatus.SC_OK, responseWrapper);
        });
    }

    // 2. Option
    @Step("Create new store model request with {/store/order} path and valid orderID")
    public PetStoreModel createPetSuccessfully(PetStoreModel request) {
        ResponseWrapper responseWrapper = createOrder(request);
        checkStatusResponse(HttpStatus.SC_OK, responseWrapper);
        return responseWrapper.as(PetStoreModel.class);
    }

    @Step("Check correct status")
    private void checkStatusResponse(int ExpectedStatus, ResponseWrapper responseWrapper) {
        assertThat(responseWrapper.getStatusCode(), equalTo(ExpectedStatus));
    }
}
