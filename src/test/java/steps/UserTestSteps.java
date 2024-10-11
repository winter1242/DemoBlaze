package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.codec.digest.DigestUtils;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSteps {
    private Response response;
    private ValidatableResponse json;
    private JSONObject body;
    private String idUser;


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

    @And("Obtengo el nombre {word} y el apellido {word}")
    public void contenidoEsperado(String nombre, String apellido) {


        response
                .then()
                .body("data.first_name", equalTo(nombre))
                .body("data.last_name", equalTo(apellido));


    }

    @And("Obtengo la imagen")
    public void validarImagen() throws IOException {
        response = RestAssured.get("https://reqres.in/img/faces/2-image.jpg");
        String actualHash = DigestUtils.md5Hex(response.asByteArray());
        String expectedHash = DigestUtils.md5Hex(Files.readAllBytes(new File("src/test/resources/imagen/persona.jpg").toPath()));
        assertEquals(expectedHash, actualHash);
    }

    @Given("Envio el post al endpoint con el nombre {word} y trabajo {word}")
    public void enviarPostRequest(String nombre, String job) {
        body = new JSONObject();
        body.put("name", nombre);
        body.put("job", job);

        response = given()
                .baseUri("https://reqres.in")
                .body(body.toString())
                .contentType(ContentType.JSON)
                .when()
                .post("/api/users");

        idUser = response.then().extract().path("id");
    }

    @And("Obtengo el nombre y trabajo")
    public void validarCampos() {
        response
                .then()
                .body("name", equalTo(body.get("name")))
                .body("job", equalTo(body.get("job")));
    }

    @Given("Envio el put al endpoint con el nombre {word} y trabajo {word}")
    public void enviarPutRequest(String nombre, String trabajo) {
        body = new JSONObject();
        body.put("name", nombre);
        body.put("job", trabajo);

        response = given()
                .baseUri("https://reqres.in")
                .body(body.toString())
                .contentType(ContentType.JSON)
                .when()
                .put("/api/users/" + idUser);
        response.then().log().all();
    }

    @Given("Envio el delete del endpoint")
    public void enviarDeleteRequest() {
        response = given()
                .baseUri("https://reqres.in")
                .contentType(ContentType.JSON)
                .when()
                .delete("/api/users/" + idUser);
    }
}
