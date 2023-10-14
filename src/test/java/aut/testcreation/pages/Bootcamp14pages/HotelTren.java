package aut.testcreation.pages.Bootcamp14pages;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HotelTren extends SeleniumWrapper {
    public HotelTren(WebDriver driver) {
        super(driver);
    }

    public void seleccionarOrigen() throws InterruptedException {
        Thread.sleep(5000);
        WebElement inputOrigen = driver.findElement(By.xpath("//input[@id=':Rb8qjalamt2mm:']"));
        inputOrigen.clear();
        Thread.sleep(5000);
        By localizadorOrigen = By.xpath(" //div[.//label[@id=':Rb8qjalamt2mm:-label'][contains(., 'Origen')]]/input");
        click(esperarXElementoLocalizado(localizadorOrigen));
        Thread.sleep(5000);
        escribirTexto(localizadorOrigen, "Madrid");
    }
    public void seleccionarDestino() throws InterruptedException {
        Thread.sleep(5000);
        WebElement inputDestino = driver.findElement(By.xpath("//input[@id=':Rd8qjalamt2mm:' and @aria-label='Destino']"));
        inputDestino.clear();
        Thread.sleep(5000);
        By localizadorDesino = By.xpath(" //input[@id=':Rd8qjalamt2mm:' and @aria-label='Destino']");
        click(esperarXElementoLocalizado(localizadorDesino));
        Thread.sleep(5000);
        escribirTexto(localizadorDesino, "Barcelona");
    }

    public void ingresarFechaSalidaLarga() throws InterruptedException {
        By localizadorFechaSalida = By.xpath("//button[@aria-label='Fecha de ida']//span");
        click(localizadorFechaSalida);
        Thread.sleep(3000);
        By siguienteMes = By.cssSelector("button[aria-label='Next month']");
        click(siguienteMes);
        click(siguienteMes);
        click(siguienteMes);
        click(siguienteMes);
        click(siguienteMes);
        click(siguienteMes);
        click(siguienteMes);
        click(siguienteMes);
        click(siguienteMes);
        click(siguienteMes);
        click(siguienteMes);
        click(siguienteMes);
        click(siguienteMes);
        click(siguienteMes);
        click(siguienteMes);
        By estaDisabled = By.cssSelector("button.d-7ws88j[tabindex='-1']");
        isDisplayed2(estaDisabled);
    }

    public boolean detectaErrorFecha(){
        By confirmacion = By.xpath("//p[contains(text(),'Verificación y pago')]");
        if(confirmacion!=null){
            return true;
        }
        return false;
    }

}