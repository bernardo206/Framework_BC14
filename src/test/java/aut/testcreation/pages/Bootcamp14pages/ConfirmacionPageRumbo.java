package aut.testcreation.pages.Bootcamp14pages;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmacionPageRumbo extends SeleniumWrapper {
    public ConfirmacionPageRumbo(WebDriver driver) {
        super(driver);
    }
    public boolean confirmacion(){
        boolean existe;
        By confirmacion = By.xpath("//p[contains(text(),'Verificación y pago')]");
        if(confirmacion!=null){
            return true;
        }
        return false;
    }

}
