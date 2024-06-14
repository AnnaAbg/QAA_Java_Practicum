package steps;

import dto.data.PetModel;
import dto.requests.PetApiRequests;
import io.qameta.allure.Step;
import io.restassured.specification.RequestSpecification;
import utils.ResponseWrapper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static utils.testDataHelper.TestDataPetHelper.*;
import static utils.testObjectBuilder.TestPetBuilder.getAddNewPetModel;

public class ServicePetSteps extends PetApiRequests {

    public ServicePetSteps(RequestSpecification requestSpecification) {
        super(requestSpecification);
    }

    @Step("Create Pet request with valid id {/pet} path")
    public ServicePetSteps createPetSuccessfully() {
        PetModel petRequest = getAddNewPetModel(VALID_RANDOM_PET_ID);
        ResponseWrapper responseWrapper =  createNewPet(petRequest);
        checkStatusResponse(responseWrapper.getStatusCode(), responseWrapper);
        return this;
    }


    @Step("Check correct status {status}")
    private void checkStatusResponse(int ExpectedStatus, ResponseWrapper responseWrapper) {
        assertThat(responseWrapper.getStatusCode(), equalTo(ExpectedStatus));
    }
}
