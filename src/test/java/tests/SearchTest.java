package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SearchPage;
import utils.WebDriverManagerUtil;

public class SearchTest {

    private WebDriver driver;
    private SearchPage searchPage;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverManagerUtil.getDriver();
        driver.get("https://dev.market.orion.global/es/store/");  // URL base de la página
        searchPage = new SearchPage(driver);
    }

    @Test
    public void searchProductTest() {
        String searchKeyword = " Tooglebox Premium ";  // Producto a buscar
        searchPage.searchProduct(searchKeyword);


        // Validar que se encuentren resultados y capturar el primero
        String[] productDetails = searchPage.getFirstProductDetails();
        String productName = productDetails[0];
        String productPrice = productDetails[0];

        // Validación
        Assert.assertNotNull(productName, "El nombre del producto no debería ser nulo.");
        Assert.assertNotNull(productPrice, "El precio del producto no debería ser nulo.");

        // Imprimir en consola
        System.out.println("Producto encontrado:");
        System.out.println("Nombre: " + productName);
        System.out.println("Precio: " + productPrice);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


