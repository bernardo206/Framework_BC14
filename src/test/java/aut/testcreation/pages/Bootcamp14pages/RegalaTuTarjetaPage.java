package aut.testcreation.pages.Bootcamp14pages;


import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegalaTuTarjetaPage extends SeleniumWrapper {
    public RegalaTuTarjetaPage(WebDriver driver) {
        super(driver);
    }

    By locatorRegalaTuTarjeta = By.xpath("//button[@class='q-btn q-btn-item non-selectable no-outline q-btn--standard q-btn--rectangle bg-primary text-white q-btn--actionable q-focusable q-hoverable q-btn--no-uppercase full-width floating-button']");

    public void Regala(){
        click(esperarXElementoLocalizado(locatorRegalaTuTarjeta));
    }

}