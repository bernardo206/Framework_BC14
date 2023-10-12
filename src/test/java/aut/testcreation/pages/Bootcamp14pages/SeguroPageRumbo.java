package aut.testcreation.pages.Bootcamp14pages;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeguroPageRumbo extends SeleniumWrapper {


    public SeguroPageRumbo(WebDriver driver) {
        super(driver);
    }

    public void seleccionarSeguro() throws InterruptedException {
        Thread.sleep(5000);
        By seguro =By.xpath("//label[input[@type='radio']]");
        clickearPorPos(seguro,0);
    }
    public void confirmarSeguro(){
        By siguiente = By.xpath("//button[contains(text(),'Siguiente')]");
        click(siguiente);
    }
}
