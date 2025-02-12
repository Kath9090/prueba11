package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.SearchPage;
import utils.WebDriverManagerUtil;

public class SearchTest {

    private WebDriver driver;
    private SearchPage searchPage;

    @BeforeClass
    public void setUp() {
        // Inicializar el WebDriver y la página de búsqueda
        driver = WebDriverManagerUtil.getDriver();
        searchPage = new SearchPage(driver);
        driver.get("https://dev.market.orion.global/es/store/"); // Asegúrate de abrir la URL correcta
    }

    @Test
    public void searchProductTest() {
        // Llamar al método que hace clic en el botón de búsqueda
        searchPage.clickSearchButton();
       // System.out.println("Botón de búsqueda clickeado exitosamente.");
    }
}
