package starter.Reqres;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class SingleUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //Scenario 1
    @Given("Get single user with valid parameter id {int}")
    public void getSingleUserWithValidParameterIdId(int id) {
        reqresAPI.getSingleUser(id);
    }

    @When("Send get single user request")
    public void sendGetSingleUserRequest() {
        SerenityRest.when()
                .get(ReqresAPI.GET_SINGLE_USER);
    }

    @Given("Get single user with invalid parameter id {string}")
    public void getSingleUserWithInvalidParameterId(String id) {
        reqresAPI.getSingleUserInvalid(id);
    }

    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int id) {
        SerenityRest.then()
                .statusCode(id);
    }


}
