package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefination extends Utils {
    private RequestSpecification res;
    private ResponseSpecification resSpec;
    private Response response;
    TestDataBuild td = new TestDataBuild();
    static String place_id;

    @Given("^Add place PayLoad$")
    @Given("Add place PayLoad {string} {string} {string}")
    public void add_place_PayLoad(String name, String language, String address) throws IOException {

        // separate the request type and assign to variable
        res = given().spec(requestSpecification()).body(td.addPlacePayload(name, language, address));

    }

    @When("user calls {string} with {string} http request")
    public void user_calls_with_http_request(String resource, String method) {
        APIResources resourceAPI = APIResources.valueOf(resource);

        resSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

        if (method.equalsIgnoreCase("POST")) {
            response = res.when().post(resourceAPI.getResource());
        } else if (method.equalsIgnoreCase("GET")) {
            response = res.when().get(resourceAPI.getResource());
        }

    }
    // .then().spec(resSpec).extract().response();

    @Then("the API call got success with status code {int}")
    public void the_API_call_got_success_with_status_code(Integer int1) {
        // Write code here that turns the phrase above into concrete actions

        assertEquals(response.getStatusCode(), 200);
    }

    @And("^\"([^\"]*)\" in response body should be \"([^\"]*)\"$")
    public void something_in_response_body_should_be_something(String keyValue, String expectedValue) throws Throwable {

        assertEquals(getJsonPath(response, keyValue), expectedValue);
    }

    @Then("verify that place_id created maps to {string} using {string}")
    public void verify_that_place_id_created_maps_to_using(String expectedName, String resource) throws IOException {
        // Write code here that turns the phrase above into concrete actions
        place_id = getJsonPath(response, "place_id");
        res = given().spec(requestSpecification()).queryParam("place_id", place_id);
        user_calls_with_http_request(resource, "GET");
        String actulName = getJsonPath(response, "name");
        assertEquals(actulName, expectedName);

    }

    @Given("delete place payload")
    public void delete_place_payload() throws IOException {
        // Write code here that turns the phrase above into concrete actions

        res = given().spec(requestSpecification()).body(td.deletePlacePayload(place_id));
    }
}
