package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserTestSteps {
    private Response response;
    private ValidatableResponse json;

    @Given("Envio un GET al endpoint")
    public void envioGetRequest() {
        response = given()
                .baseUri("https://reqres.in")
                .contentType(ContentType.JSON)
                .when()
                .get("/api/users/2");

    }

    @Then("^Obtengo un codigo de status (\\d+)$")
    public void codigoEsperado(int codigoEsperado) {
        response.then().statusCode(codigoEsperado);
    }
}
