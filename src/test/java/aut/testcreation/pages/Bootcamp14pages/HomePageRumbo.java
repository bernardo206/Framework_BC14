package aut.testcreation.pages.Bootcamp14pages;


import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Set;

public class HomePageRumbo extends SeleniumWrapper {


    public HomePageRumbo(WebDriver driver) {
        super(driver);
    }


    // DEFINIR LOCALIZADORES-----------------------------------------------------------------------


    By localizadorBotonCookies = By.xpath("//button[contains(text(), 'Aceptar todo')]");
    By localizadorSoloIda = By.xpath("//div[contains(text(),'Solo ida')]");

    By locatorVerMas = By.xpath("(//div[@class='MenuLinkstyled__MenuLinkWrapper-sc-1dkmpyp-2 ixtBwj'])[11]");
    By btnTrenes = By.xpath("//div[@class='MenuLinkstyled__MenuTextWrapper-sc-1dkmpyp-4 KZClY' and text()='Trenes']");

    By btnTrenHotel = By.xpath("//div[contains(text(),'Tren + Hotel')]");








   // WebElement despVuelos = driver.findElement( By.xpath("//a[@title='Vuelos']"));

  //  By clickVuelosOu = By.xpath("//div[contains(@class, 'MenuLinkstyled__MenuTextWrapper-sc-1dkmpyp-4 KZClY') and text()='Outlet Vuelos']");




    // CENTRALIZAR ACCIONES------------------------------------------------------------------------

    public void aceptarCookies(){
     click(esperarXElementoLocalizado(localizadorBotonCookies));
    }

    public void seleccionarVueloSoloIda(){
        click(esperarXElementoLocalizado(localizadorSoloIda));
    }
    public void ingresarOrigen() throws InterruptedException {
        Thread.sleep(5000);
        WebElement inputOrigen = driver.findElement(By.xpath("//input[@id=':R9d96jalaldq2mm:']"));
        inputOrigen.clear();
        Thread.sleep(5000);
        By localizadorOrigen = By.xpath(" //div[.//label[@id=':R9d96jalaldq2mm:-label'][contains(., 'Origen')]]/input");
        click(esperarXElementoLocalizado(localizadorOrigen));
        Thread.sleep(5000);
        escribirTexto(localizadorOrigen, "Madrid (MAD)");
    }
   public void ingresarDestino() throws InterruptedException {
       Thread.sleep(5000);
       WebElement inputDestino = driver.findElement(By.xpath("//input[@id=':R9d96jalaldq2mm:']"));
       inputDestino.clear();
       Thread.sleep(3000);
       By localizadorDestino = By.xpath(" //div[.//label[@id=':R9l96jalaldq2mm:-label'][contains(., 'Destino')]]/input");
       click(esperarXElementoLocalizado(localizadorDestino));
       Thread.sleep(3000);
       escribirTexto(localizadorDestino, "Barcelona (BCN)");
       Thread.sleep(3000);
    }
    public void ingresarFechaSalida() throws InterruptedException {
        By localizadorFechaSalida = By.xpath("//button[@aria-label='Fecha de ida']//span");
        click(localizadorFechaSalida);
        Thread.sleep(3000);
        By diaSalida = By.xpath("//div//div[.//span[@id='10']]//button[contains(text(), '14')]");
        click(diaSalida);
    }

    public void ingresarCantidadPasajeros(){
    }

    public void buscar(){
        By localizadorBtnBuscar = By.xpath("//button[@type='submit']");
        click(localizadorBtnBuscar);
    }
    public void locatorVerMas(){
        click(esperarXElementoLocalizado(locatorVerMas));
    }

    public void btnTrenes(){
        click(esperarXElementoLocalizado(btnTrenes));
    }


    public void btnTrenHotel(){
        click(esperarXElementoLocalizado(btnTrenHotel));
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


    public void aceptarCookiesIngles(){
        By localizadorBotonCookies = By.xpath("//button[contains(text(), 'Accept all')]");
        click(esperarXElementoLocalizado(localizadorBotonCookies));
    }


    public boolean selectOneWay(){
        By localizadorSoloIda = By.xpath("//div[contains(text(),'One-way')]");
        if(localizadorSoloIda!=null){
            return true;
        }
        return false;
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





/*
    public void desplegableVuelos(){

        actions.moveToElement(despVuelos).build().perform();

    }

    public void ClickVuelosOutlt(){
        click(esperarXElementoLocalizado(clickVuelosOu));
    }
*/





}
