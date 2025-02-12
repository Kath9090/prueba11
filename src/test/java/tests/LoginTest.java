package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.WebDriverManagerUtil;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        // Inicializar el WebDriver
        driver = WebDriverManagerUtil.getDriver();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginTest() {
        // Flujo de login
        loginPage.entrarButton(); // Haz clic en el botón "Entrar"
        loginPage.enterUsername("cuentademoorionhub@gmail.com"); // Ingresar usuario
        loginPage.enterPassword("12345678Fs"); // Ingresar contraseña
        loginPage.clickLoginButton(); // Haz clic en el botón de login

        // Validación: Verificar si el login fue exitoso
        Assert.assertTrue(loginPage.isLoginSuccessful(), "El inicio de sesión falló");
    }
    @AfterClass
    public void tearDown() {
        // Cerrar el navegador
        WebDriverManagerUtil.closeDriver();
    }
}

