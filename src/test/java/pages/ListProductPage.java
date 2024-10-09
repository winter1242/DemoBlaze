package pages;

public class ListProductPage extends BasePage {
    private String linkCelText = "//a[contains(text(),'Phones')]";
    private String productLinkText = "//a[contains(text(),'%s')]";

    public ListProductPage() {
        super(driver);
    }

    public void clickPhoneSection() {
        clickElement(linkCelText);
    }

    public void clickProduct(String producto) {
        clickElement(String.format(productLinkText, producto));
    }
}
