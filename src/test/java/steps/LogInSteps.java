package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LogInPage;
import pages.MainPage;

public class LogInSteps {
    MainPage paginaPrincipal = new MainPage();
    LogInPage paginaLogIn = new LogInPage();

    @Given("Estoy en la pagina {word}")
    public void iNavigateToFRT(String pagina) {
        paginaPrincipal.navitageToBlazePage(pagina);
    }

    @When("Realizo clic en el log in")
    public void clicLogIn() {
        paginaPrincipal.clickLogInLink();
    }

    @And("Ingreso el correo {word}")
    public void ingresarCorreo(String correo) {
        paginaLogIn.ingresarCorreo(correo);
    }

    @And("Ingresa la contrasena {word}")
    public void ingresarContrasena(String contrasena) {
        paginaLogIn.ingresarContrasena(contrasena);
    }

    @And("Realiza clic en el boton LogIn")
    public void clicBtnLogIn() {
        paginaLogIn.clicLogIn();
    }

    @Then("Se mostrara el mensaje de bienvenida {word}")
    public void validacionMensaje(String correo) {
        var mensaje = "Welcome " + correo;

        Assert.assertEquals(mensaje, paginaPrincipal.mensajeBienvenida());
    }


}
