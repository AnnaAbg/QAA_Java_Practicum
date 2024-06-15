package PetTests;

import base.BaseTest;
import dto.data.PetModel;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static utils.RandomDataHelper.getRandomNotValidStatus;
import static utils.StatusCode.STATUS_CODE_OK;
import static utils.testDataHelper.TestDataPetHelper.VALID_STATUS;
import static utils.testObjectBuilder.TestPetBuilder.getAddNewPetModel;

/**
 * This class contains tests for finding pets by status.
 */

@Epic("Find Pet By Status")
@Feature("Find Pets")
public class GetPetsByStatusTest extends BaseTest {

    @Severity(SeverityLevel.NORMAL)
    @Story("Find pets by status - Happy Path")
    @Description("Check finding pets by status with a valid status.")
    @Test
    public void testFindPetsByStatus_HappyPath() {

        step("Create request with /pet path", () -> {
            responseWrapper = petApiRequests.createNewPet(petRequest = getAddNewPetModel(VALID_STATUS));
        });


        step("Post request with /pet path", () -> {
            responseWrapper = petApiRequests.getPetByStatus(VALID_STATUS);
        });

        step("Check response", () -> {
            int statusCode = responseWrapper.getStatusCode();
            List<PetModel> response = responseWrapper.asList(PetModel[].class);

            assertSoftly(
                    softAssertions -> {
                        softAssertions
                                .assertThat(statusCode)
                                .withFailMessage("Status code doesn't match")
                                .isEqualTo(STATUS_CODE_OK);
                        softAssertions
                                .assertThat(response)
                                .withFailMessage("Response body is empty")
                                .isNotEmpty();
                    }
            );
        });
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("Find pets by status - Status Null")
    @Description("Check finding pets by status when status is null.")
    @Test
    public void testFindPetsByStatusIfStatusNull() {

        step("Create pet model request with /pet path", () -> {
            responseWrapper = petApiRequests.createNewPet(petRequest = getAddNewPetModel(getRandomNotValidStatus()));
        });

        step("Get request with /pet/findByStatus path", () -> {
            responseWrapper = petApiRequests.getPetByStatus(getRandomNotValidStatus());
        });

        step("Check response and status code", () -> {
            int statusCode = responseWrapper.getStatusCode();
            List<PetModel> response = responseWrapper.asList(PetModel[].class);

            assertSoftly(
                    softAssertions -> {
                        softAssertions
                                .assertThat(statusCode)
                                .withFailMessage("Status code doesn't match")
                                .isEqualTo(STATUS_CODE_OK);
                        softAssertions
                                .assertThat(response)
                                .withFailMessage("Response body is not empty")
                               .isEmpty();
                    }
            );
        });
    }
}
