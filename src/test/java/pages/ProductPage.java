package pages;

public class ProductPage extends BasePage {
    private String addToCartBtn = "//a[contains(text(),'Add to cart')]";
    private String homeBtn = "//a[contains(text(),'Home ')]";

    public ProductPage() {
        super(driver);
    }

    public void clickAgregarProducto() {
        clickElement(addToCartBtn);
    }

    public void cerrarAlerta() {
        aceptAlert();
    }

    public void clickHome() {
        clickElement(homeBtn);
    }

}
