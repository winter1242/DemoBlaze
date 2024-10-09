package pages;

public class LogInPage extends BasePage {
    private String userNameTxt = "//input[@id='loginusername']";
    private String passwordTxt = "//input[@id='loginpassword']";
    private String logInBtn = "//button[text()='Log in']";

    public LogInPage() {
        super(driver);
    }

    public void ingresarCorreo(String correo) {
        clickElement(userNameTxt);
        write(userNameTxt, correo);
    }

    public void ingresarContrasena(String contrasena) {
        clickElement(passwordTxt);
        write(passwordTxt, contrasena);
    }

    public void clicLogIn() {
        clickElement(logInBtn);
    }

}
