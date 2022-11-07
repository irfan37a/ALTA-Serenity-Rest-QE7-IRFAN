package starter.Reqres;

import com.github.fge.jsonschema.main.JsonSchema;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class ReqresStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //scenario 1
    @Given("Get list user with valid parameter page {int}")
    public void getListUserWithValidParameterPage(int page) {
        reqresAPI.getListUser(page);
    }

    @When("Send get list user request")
    public void sendGetListUserRequest() {
        SerenityRest.when()
                .get(ReqresAPI.GET_LIST_USER);
    }

    @Then("Status code should be {int} ok")
    public void statusCodeShouldBeOk(int OK) {
        SerenityRest.then()
                .statusCode(OK);
    }

    @And("Response body page should be {int}")
    public void responseBodyPageShouldBe(int page) {
        SerenityRest.then()
                .body(ReqresResponses.PAGE,equalTo(page));
    }

    @And("Validate get list user json chema")
    public void validateGetListUserJsonChema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/GetListUserJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario 2
    @Given("Post create user with valid json")
    public void postCreateUserWithValidJson() {
        File json = new File(ReqresAPI.JSON_REQ_BODY+"/CreateUser.json");
        reqresAPI.postCreateNewUser(json);
    }

    @When("Send post create user request")
    public void sendPostCreateUserRequest() {
        SerenityRest.when()
                .post(ReqresAPI.POST_CREATE_NEW_USER);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then()
                .statusCode(created);
    }

    @And("Response body should contain name {string} and job {string}")
    public void responseBodyShouldContainNameAndJob(String name, String job) {
        SerenityRest.then()
                .body(ReqresResponses.NAME,equalTo(name))
                .body(ReqresResponses.JOB,equalTo(job));
    }

    @And("Validate create user json schema")
    public void validateCreateUserJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/CreateUserJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }


    //Scenario 3
    @Given("Put update user with valid json with id {int}")
    public void putUpdateUserWithValidJsonWithId(int id) {
        File json = new File(ReqresAPI.JSON_REQ_BODY+"/UpdateUser.json");
        reqresAPI.putUpdateUser(id,json);
    }

    @When("Send put update user request")
    public void sendPutUpdateUserRequest() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }

    @And("Validate put update json schema")
    public void validatePutUpdateJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/PutUpdateJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario 4
    @Given("Delete user with {int}")
    public void deleteUserWithId(int id) {
        reqresAPI.deleteUSer(id);
    }
    @When("Send delete user request")
    public void sendDeleteUserRequest() {
        SerenityRest.when()
                .delete(ReqresAPI.DELETE_USER);

    }
    @Then("Status code should be {int} No COntent")
    public void statusCodeShouldBeNoCOntent(int noContent) {
        SerenityRest.then()
                .statusCode(noContent);
    }
}
