package aut.testcreation.pages.Bootcamp14pages;


import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RoomHotelPage extends SeleniumWrapper {
    public RoomHotelPage(WebDriver driver) {
        super(driver);
    }

    //By localizadorContinuar1ero = By.xpath("//button[@data-testid='checkout-button']/span[contains(text(),'Continuar')]");
    public void Continuar1ero(int indice) {
        By localizadorBotonesContinuar = By.xpath("//button[contains(@class, 'Button-sc-1bbve8d-0') and .//span[contains(text(), 'Continuar')]]");
        WebDriverWait wait = new WebDriverWait(driver, 40);
        List<WebElement> botonesContinuar = driver.findElements(localizadorBotonesContinuar);

        if (indice >= 0 && indice < botonesContinuar.size()) {
            botonesContinuar.get(indice).click();
        } else {
            System.out.println("Índice fuera de rango. Asegúrate de que el índice sea válido.");


        }
    }
}