package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManagerUtil {
    private static WebDriver driver;

    public static void main(String[] args) {
        WebDriver driver = getDriver(); // Inicializar el driver
        // Hacer algo con el driver, como navegar o verificar elementos
        closeDriver(); // Cerrar el driver
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            // Establecer la ruta correcta del ChromeDriver
            String driverPath = System.getProperty("user.dir") + "/src/test/resources/chrome/chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", driverPath); // Configuración correcta de la propiedad

            // Inicializar el navegador Chrome
            driver = new ChromeDriver();

            // Navegar a la página
            driver.get("https://dev.market.orion.global/es/store/");
            System.out.println("Página cargada: " + driver.getTitle());

            // Maximizar la ventana
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit(); // Cerrar el navegador
            driver = null; // Liberar el objeto
        }
    }
}


