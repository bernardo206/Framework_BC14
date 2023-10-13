package aut.testcreation.pages.Bootcamp14pages;


import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Set;

public class HomePageRumbo extends SeleniumWrapper {


    public HomePageRumbo(WebDriver driver) {
        super(driver);
    }


    // DEFINIR LOCALIZADORES-----------------------------------------------------------------------
    By localizadorBotonCookies = By.xpath("//button[contains(text(), 'Aceptar todo')]");
    By localizadorSoloIda = By.xpath("//div[contains(text(),'Solo ida')]");

    // CENTRALIZAR ACCIONES------------------------------------------------------------------------

    public void aceptarCookiesIngles(){
        By localizadorBotonCookies = By.xpath("//button[contains(text(), 'Accept all')]");
     click(esperarXElementoLocalizado(localizadorBotonCookies));
    }
    public void aceptarCookies(){
        click(esperarXElementoLocalizado(localizadorBotonCookies));
    }

    public void seleccionarVueloSoloIda(){
        click(esperarXElementoLocalizado(localizadorSoloIda));
    }
    public void ingresarOrigen(String texto) throws InterruptedException {
        Thread.sleep(5000);
        WebElement inputOrigen = driver.findElement(By.xpath("//input[@id=':R9d96jalaldq2mm:']"));
        inputOrigen.clear();
        Thread.sleep(5000);
        By localizadorOrigen = By.xpath(" //div[.//label[@id=':R9d96jalaldq2mm:-label'][contains(., 'Origen')]]/input");
        click(esperarXElementoLocalizado(localizadorOrigen));
        Thread.sleep(5000);
        escribirTexto(localizadorOrigen, texto);
    }
   public void ingresarDestino(String texto) throws InterruptedException {
       Thread.sleep(5000);
       WebElement inputDestino = driver.findElement(By.xpath("//input[@id=':R9d96jalaldq2mm:']"));
       inputDestino.clear();
       Thread.sleep(3000);
       By localizadorDestino = By.xpath(" //div[.//label[@id=':R9l96jalaldq2mm:-label'][contains(., 'Destino')]]/input");
       click(esperarXElementoLocalizado(localizadorDestino));
       Thread.sleep(3000);
       escribirTexto(localizadorDestino, texto);
       Thread.sleep(3000);
    }
    public void ingresarFechaSalida(String mes , String dia) throws InterruptedException {
        By localizadorFechaSalida = By.xpath("//button[@aria-label='Fecha de ida']//span");
        click(localizadorFechaSalida);
        Thread.sleep(3000);
        By diaSalida = By.xpath("//div//div[.//span[@id="+mes+"]]//button[contains(text(),"+dia+")]");
        click(diaSalida);
    }

    public void buscar(){
        By localizadorBtnBuscar = By.xpath("//button[@type='submit']");
        click(localizadorBtnBuscar);
    }

    public void seleccionarPais() throws InterruptedException {
        By seleccion = By.xpath("//div//*[@id=\"globe_svg__filled\"]");
        click(seleccion);
        Thread.sleep(3000);
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            driver.switchTo().window(handle);
            By ingles = By.xpath("//p[text()='Worldwide (English)']");
            click(ingles);
        }
        String mainWindowHandle = driver.getWindowHandle();
        driver.switchTo().window(mainWindowHandle);
    }

    public boolean selectOneWay(){
        By localizadorSoloIda = By.xpath("//div[contains(text(),'One-way')]");
        if(localizadorSoloIda!=null){
            return true;
        }
        return false;
    }


}
