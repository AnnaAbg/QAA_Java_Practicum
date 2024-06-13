package steps;

import dto.data.PetModel;
import dto.requests.PetApiRequests;
import dto.response.APIResponse;
import dto.response.ErrorResponse;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import utils.ResponseWrapper;

import static io.qameta.allure.Allure.step;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static utils.StatusCode.STATUS_CODE_OK;
import static utils.expectedObjectBuilder.ExpectedErrorObjectBuilder.getUnknownErrorResponse;
import static utils.testDataHelper.TestDataPetHelper.*;
import static utils.testObjectBuilder.TestPetBuilder.getAddNewPetModel;

public class ServicePetSteps extends PetApiRequests {

    public ServicePetSteps(RequestSpecification requestSpecification) {
        super(requestSpecification);
    }

    // 1. Option
    public void createNewPetModel() {
        step("Create new pet model with different name and status", () -> {
            PetModel petRequest = getAddNewPetModel(VALID_RANDOM_PET_ID, PENDING_STATUS);
            ResponseWrapper responseWrapper = createNewPet(petRequest);
        });
    }

    // 2. Option
    @Step("Create Pet request with valid id {/pet} path")
    public ServicePetSteps createPetSuccessfully() {
        PetModel petRequest = getAddNewPetModel(VALID_RANDOM_PET_ID);
        ResponseWrapper responseWrapper = createNewPet(petRequest);
        checkStatusResponse(responseWrapper.getStatusCode(), responseWrapper);
        return this;
    }


    @Step("Check correct status {status}")
    private void checkStatusResponse(int ExpectedStatus, ResponseWrapper responseWrapper) {
        assertThat(responseWrapper.getStatusCode(), equalTo(ExpectedStatus));
    }
}
