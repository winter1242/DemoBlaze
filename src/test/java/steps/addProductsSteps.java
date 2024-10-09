package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.ListProductPage;
import pages.MainPage;
import reader.ExcelReader;

public class addProductsSteps {
    MainPage paginaPrincipal = new MainPage();
    ListProductPage listProductPage = new ListProductPage();

    @When("Selecciono la categoia Phone")
    public void seleccionarCategoria() {
        listProductPage.clickPhoneSection();
    }

    @And("Selecciono el producto en la lista")
    public void seleccionarProducto() {
        listProductPage.clickProduct(ExcelReader.obtenerListaProducto().get(0).getNombre());
    }
}
