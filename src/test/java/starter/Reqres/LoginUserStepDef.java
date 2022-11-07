package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class LoginUserStepDef {
        @Steps
        ReqresAPI reqresAPI;

    @Given("Post login user with valid parameter")
    public void postRegisterUserWithValidParameter() {
        File json = new File(ReqresAPI.JSON_REQ_BODY+"/LoginUser.json");
        reqresAPI.postLoginUser(json);
    }
    @When("Post login user request")
    public void postRegisterUserRequest() {
        SerenityRest.when()
                .post(ReqresAPI.POST_LOGIN_USER);
    }

    @And("Response body should contain token {string}")
    public void responseBodyShouldContainIdAndToken(String token) {
        SerenityRest.then()
                .body(ReqresResponses.TOKEN,equalTo(token));
    }
}
