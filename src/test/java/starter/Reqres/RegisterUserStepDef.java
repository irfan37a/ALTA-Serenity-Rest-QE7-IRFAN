package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class RegisterUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //Scenario 1
    @Given("Post register user with valid parameter")
    public void postRegisterUserWithValidParameter() {
        File json = new File(ReqresAPI.JSON_REQ_BODY+"/RegisterUser.json");
        reqresAPI.postRegisterUser(json);
    }

    @When("Post register user request")
    public void postRegisterUserRequest() {
        SerenityRest.when()
                .post(ReqresAPI.POST_REGISTER_USER);
    }

    @And("Response body should contain id {int} and token {string}")
    public void responseBodyShouldContainIdAndToken(int id, String token) {
        SerenityRest.then()
                .body(ReqresResponses.ID,equalTo(id))
                .body(ReqresResponses.TOKEN,equalTo(token));
    }
}
