package pages;

import java.util.List;

public class CartPage extends BasePage {
    private String nombreProducto = "//tr[@class='success']/td[2]";

    public CartPage() {
        super(driver);
    }

    public List<String> listProducto() {
        return getTextElements(nombreProducto);
    }


}

