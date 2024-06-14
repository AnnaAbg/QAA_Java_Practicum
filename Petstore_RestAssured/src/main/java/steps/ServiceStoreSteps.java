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

public class ServiceStoreSteps extends StoreApiRequests {

    public ServiceStoreSteps(RequestSpecification requestSpecification) {
        super(requestSpecification);
    }

    @Step("Create new store model request with {/store/order} path and valid orderID")
    public PetStoreModel createPetSuccessfully(PetStoreModel request) {
        ResponseWrapper responseWrapper = createOrder(request);
        checkStatusResponse(HttpStatus.SC_OK, responseWrapper);
        return responseWrapper.as(PetStoreModel.class);
    }

    @Step("Check correct status")
    private void checkStatusResponse(int expectedStatus, ResponseWrapper responseWrapper) {
        assertThat(responseWrapper.getStatusCode(), equalTo(expectedStatus));
    }
}
