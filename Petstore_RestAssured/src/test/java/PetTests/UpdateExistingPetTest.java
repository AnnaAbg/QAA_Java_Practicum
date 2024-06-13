package PetTests;

import base.BaseTest;
import dto.data.PetModel;
import dto.response.ErrorResponse;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static utils.StatusCode.STATUS_CODE_ERROR_500;
import static utils.StatusCode.STATUS_CODE_OK;
import static utils.expectedObjectBuilder.ExpectedErrorObjectBuilder.getUnknownErrorResponse;
import static utils.testDataHelper.TestDataPetHelper.*;
import static utils.testObjectBuilder.TestPetBuilder.getAddEmptyPetModel;
import static utils.testObjectBuilder.TestPetBuilder.getAddNewPetModel;

/**
 * This class contains tests for updating an existing pet in the store and invalid pet ID scenarios.
 */

@Epic("Update Existing Pet In Store")
@Feature("Update Pet")
public class UpdateExistingPetTest extends BaseTest {

    @Severity(SeverityLevel.NORMAL)
    @Story("Update existing pet in the store")
    @Description("Check updating an existing pet in the store.")
    @Test
    public void testUpdateExistingPet() {

        step("Create new pet model with different name and status", () -> {
            petRequest = getAddNewPetModel(VALID_RANDOM_PET_ID, PENDING_STATUS);
        });

        step("Update/put request with /pet path", () -> {
            responseWrapper = petApiRequests.updatePet(petRequest);
        });

        step(" Check response ,status code, petID, name & status", () -> {
            int statusCode = responseWrapper.getStatusCode();
            PetModel response = responseWrapper.as(PetModel.class);

            assertSoftly(
                    softAssertions -> {
                        assertThat(statusCode)
                                .withFailMessage("Status code doesn't match")
                                .isEqualTo(STATUS_CODE_OK);
                        assertThat(response)
                                .withFailMessage("Response body doesn't match")
                                .isEqualTo(petRequest);
                        assertThat(response.getId())
                                .withFailMessage("Response body doesn't match")
                                .isEqualTo(petRequest.getId());
                        assertThat(response.getName())
                                .withFailMessage("Response body doesn't match")
                                .isEqualTo(petRequest.getName());
                        assertThat(response.getStatus())
                                .withFailMessage("Response body doesn't match")
                                .isEqualTo(petRequest.getStatus());

                    }
            );
        });

    }

    @Severity(SeverityLevel.NORMAL)
    @Story("Pet not found error")
    @Description("Check handling pet not found error during pet update.")
    @Test
    public void testPetIsNotFound() {

        step("Create empty pet model", () -> {
            petRequest = getAddEmptyPetModel(SOLD_STATUS);
        });

        step("Update/put request with /pet path", () -> {
            responseWrapper = petApiRequests.updatePet(petRequest);
        });

        step(" Check response and status code", () -> {
            int statusCode = responseWrapper.getStatusCode();
            ErrorResponse error = responseWrapper.as(ErrorResponse.class);

            assertSoftly(
                    softAssertions -> {
                        softAssertions
                                .assertThat(statusCode)
                                .withFailMessage("Status code doesn't match")
                                .isEqualTo(STATUS_CODE_ERROR_500);
                        softAssertions
                                .assertThat(error)
                                .withFailMessage("Error body doesn't match")
                                .isEqualTo(getUnknownErrorResponse());
                    }
            );
        });
    }
}
