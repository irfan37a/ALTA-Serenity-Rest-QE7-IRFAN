package starter.Reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class ReqresAPI {
    public static final String URL = "https://reqres.in";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_REQ_BODY = DIR+"/src/test/resources/JSON/RequestBody";
    public static final String JSON_SCHEMA = DIR+"/src/test/resources/JSON/JsonSchema";

    public static String GET_LIST_USER = URL+"/api/users?page={page}";

    public static String GET_SINGLE_USER = URL+"/api/users/{id}";
    public static String POST_CREATE_NEW_USER = URL+"/api/users";
    public static String POST_REGISTER_USER = URL+"/api/register";
    public static String POST_REGISTER_INVALID = URL+"/api/register";
    public static String POST_LOGIN_USER = URL+"/api/login";
    public static String PUT_UPDATE_USER = URL+"/api/users/{id}";
    public static String DELETE_USER = URL+"/api/users/{id}";

    @Step("Get list user")
    public void getListUser(int page){
        SerenityRest.given()
                .pathParam("page", page);
    }
    @Step("Get Single User")
    public void getSingleUser(int id){
        SerenityRest.given()
                .pathParam("id",id);
    }
    @Step("Get Single User Invalid")
    public void getSingleUserInvalid(String id){
        SerenityRest.given()
                .pathParam("id",id);
    }

    @Step("Post create new user")
    public void postCreateNewUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post register user")
    public void postRegisterUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post register user invalid")
    public void postRegisterUserInvalid(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post login user")
    public void postLoginUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update user")
    public void putUpdateUser(int id, File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Delete user")
    public void deleteUSer(int id){
        SerenityRest.given()
                .pathParam("id",id);
    }
}
