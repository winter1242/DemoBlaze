package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.ListProductPage;
import pages.ProductPage;
import reader.ExcelReader;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class AddProductsSteps {
    ListProductPage listProductPage = new ListProductPage();
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();

    @When("Selecciono la categoia Phone")
    public void seleccionarCategoria() {
        listProductPage.clickPhoneSection();
    }

    @And("Selecciono el producto en la lista")
    public void seleccionarProducto() {
        for (var nombre : ExcelReader.obtenerListaProducto()) {
            listProductPage.clickProduct(nombre.getNombre());
            productPage.clickAgregarProducto();
            productPage.cerrarAlerta();
            productPage.clickHome();
        }

    }

    @And("Clic en el carrito de compras")
    public void clicCarritoCompras() {
        listProductPage.clicCart();
    }

    @Then("Se muestra los productos agregados")
    public void validarProducto() {
        List<String> listProduct = new ArrayList<>();
        System.out.println("El primero producto es : " + cartPage.listProducto().get(0));
        for (var nombre : ExcelReader.obtenerListaProducto()) {
            listProduct.add(nombre.getNombre());
        }
        List<String> listCart = cartPage.listProducto().stream()
                .distinct()
                .collect(Collectors.toList());

        assertThat(listCart, containsInAnyOrder(listProduct.toArray(String[]::new)));

    }

}
