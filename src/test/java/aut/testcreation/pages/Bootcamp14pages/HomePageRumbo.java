package aut.testcreation.pages.Bootcamp14pages;


import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

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





}
