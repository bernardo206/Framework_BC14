package aut.testcreation.pages.Bootcamp14pages;


import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CodigoTarjetaRegalo extends SeleniumWrapper {


    public CodigoTarjetaRegalo(WebDriver driver) {
        super(driver);
    }
    By localizadorResort = By.cssSelector("div.sc-jkTpcO.genDuQ");
    public void Resort(){
        WebDriverWait wait = new WebDriverWait(driver, 40);

        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(localizadorResort));

            element.click();
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println("El elemento no se encontró en el tiempo especificado.");
        }
    }

}

