package aut.testcreation.pages.Bootcamp14pages;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.Set;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VuelosPageRumbo extends SeleniumWrapper {
    public VuelosPageRumbo(WebDriver driver) {
        super(driver);
    }

    public void seleccionarVuelo() throws InterruptedException {
        Thread.sleep(20000);
        By localizadorVuelos = By.xpath("//div[@class='Container__StyledContainer-sc-sb5e2u-0 jqPhQa FullTransportCard__GridContainer-sc-kb0mbo-0 fJSqlK']");
        clickearPorPos(localizadorVuelos, 2);
    }

    public void confirmarVuelo() throws InterruptedException {
        Thread.sleep(3000);
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            driver.switchTo().window(handle);
            By localorBtn = By.xpath("//button[contains(text(),'Seleccionar')]");
            click(localorBtn);
        }

        String mainWindowHandle = driver.getWindowHandle();
        driver.switchTo().window(mainWindowHandle);
    }

    public void elegirTarifa(String tarifa) throws InterruptedException {
        Thread.sleep(15000);
        By localizadorSeleccionarTarifa = By.xpath("//button[contains(text(),"+tarifa+")]");
        scroll(localizadorSeleccionarTarifa);
        click(localizadorSeleccionarTarifa);
    }
}
