package aut.testcreation.pages.Bootcamp14pages;


import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DestinoPaguete extends SeleniumWrapper {
    public DestinoPaguete(WebDriver driver) {
        super(driver);
    }

    public void ElegirAlojamiento(){

        By localizadorAlojamiento = By.xpath("//div[normalize-space()='Hotel Flavia']");
        WebDriverWait wait = new WebDriverWait(driver, 40);  // Cambia el tiempo límite según tus necesidades
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(localizadorAlojamiento));
            // Una vez que el elemento esté presente, puedes interactuar con él
            element.click();  // Por ejemplo, hacer clic en el elemento
        } catch (org.openqa.selenium.TimeoutException e) {
            // Manejo de la excepción si el elemento no está presente después del tiempo límite
            System.out.println("El elemento no se encontró en el tiempo especificado.");
        }




    }

}