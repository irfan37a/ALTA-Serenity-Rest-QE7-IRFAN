package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class RegisterUserInvalidStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Post register user with invalid parameter")
    public void postRegisterUserWithInvalidParameter() {
        File json = new File(ReqresAPI.JSON_REQ_BODY+"/RegisterUnsuccess.json");
        reqresAPI.postRegisterUserInvalid(json);
    }


    @When("Post register user request invalid")
    public void postRegisterUserRequestInvalid() {
        SerenityRest.when()
                .post(ReqresAPI.POST_REGISTER_INVALID);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int id) {
        SerenityRest.then()
                .statusCode(id);
    }

    @And("Response body should contain error {string}")
    public void responseBodyShouldContainError(String error) {
        SerenityRest.then()
                .body(ReqresResponses.ERROR,equalTo(error));
    }
}
