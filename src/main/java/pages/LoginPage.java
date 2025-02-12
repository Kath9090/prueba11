package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void entrarButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement entrarButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/header/div/div/div/a[1]"))); // Ajusta el XPath según corresponda
        entrarButton.click();


        // Espera a que el campo de usuario esté visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/header/div/div/div/a[1]"))); // Cambia al ID correcto
    }

    public void enterUsername(String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\":r0:\"]"))); // Cambia al ID correcto
        usernameField.sendKeys("cuentademoorionhub@gmail.com");

    }
    public void enterPassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\":r1:\"]"))); // Cambia al ID correcto
        passwordField.sendKeys("12345678Fs");

    }

    public void clickLoginButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\":r2:\"]"))); // Cambia al ID correcto
        loginButton.click();

    }

    public boolean isLoginSuccessful() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.urlContains("/dashboard")); // Cambia por la URL esperada tras el login
    }
}

