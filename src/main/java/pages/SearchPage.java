package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class SearchPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By searchBox = By.xpath("//input[@placeholder='Buscar...']"); //
     By productList = By.cssSelector("tbody.MuiTableBody-root tr");
    private By productName = By.cssSelector("div.MuiListItemText-root span");
    private By productPrice = By.cssSelector("td:nth-child(1)"); // Ajusta si el precio está en otra columna

    // Constructor
    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Método para buscar un producto
    public void searchProduct(String productName) {
        try {
            WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
            searchInput.clear(); // Limpia el campo antes de ingresar texto
            searchInput.sendKeys(productName);
            searchInput.sendKeys(Keys.ENTER); // Simula presionar "Enter" para realizar la búsqueda
        } catch (TimeoutException e) {
            throw new RuntimeException("El campo de búsqueda no se encontró en la página.");
        }
    }

    // Método para validar resultados y capturar los detalles del primer producto
    public String[] getFirstProductDetails() {
        try {
            List<WebElement> products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productList));

            if (!products.isEmpty()) {
                WebElement firstProduct = products.get(0); // Toma el primer producto de la lista
                String name = firstProduct.findElement(productName).getText();
                String price = firstProduct.findElement(productPrice).getText();
                return new String[]{name, price};
            } else {
                throw new RuntimeException("No se encontraron productos en la lista.");
            }
        } catch (TimeoutException e) {
            throw new RuntimeException("La lista de productos no se cargó a tiempo.");
        }
    }

    // Método adicional para obtener todos los productos en la lista

    public List<String[]> getAllProductDetails() {
        try {
            List<WebElement> products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productList));
            return products.stream().map(product -> {
                String name = product.findElement(productName).getText();
                String price = product.findElement(productPrice).getText();
                return new String[]{name, price};
            }).collect(Collectors.toList());
        } catch (TimeoutException e) {
            throw new RuntimeException("La lista de productos no se cargó a tiempo.");
        }
    }
}







