package pages;

public class MainPage extends BasePage {
    private String logInLink = "//a[@id='login2']";
    private String messageLink = "//a[@id='nameofuser']";

    public MainPage() {
        super(driver);
    }

    public void clickLogInLink() {
        clickElement(logInLink);
    }

    public void navitageToBlazePage(String pagina) {
        navigateTo("https://" + pagina);
    }

    public String mensajeBienvenida() {
        return getText(messageLink);
    }
}
