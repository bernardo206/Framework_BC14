package aut.testcreation.pages.Bootcamp14pages;


import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VueloMasHotelPage extends SeleniumWrapper {
    public VueloMasHotelPage(WebDriver driver) {
        super(driver);
    }

    By localizadorVueloMasHoteles = By.xpath("//div[contains(text(),'Vuelo + Hotel')]");



    public void VueloMasHotel() {
        click(esperarXElementoLocalizado(localizadorVueloMasHoteles));
    }
    public void OrigenVuelo() throws InterruptedException {
        Thread.sleep(3000);
        WebElement inputOrigen = driver.findElement(By.xpath("//input[@id=':Rmhj9lalamt2mm:']"));
        inputOrigen.clear();
        Thread.sleep(3000);
        By localizadorOrigen = By.xpath(" //div[.//label[@id=':Rmhj9lalamt2mm:-label'][contains(., 'Origen')]]/input");
        click(esperarXElementoLocalizado(localizadorOrigen));
        Thread.sleep(3000);
        escribirTexto(localizadorOrigen, "Sao Paulo (SAO)");
    }
    public void DestinoVuelo() throws InterruptedException {
        Thread.sleep(3000);
        WebElement inputDestino = driver.findElement(By.xpath("//input[@id=':Rqhj9lalamt2mm:']"));
        inputDestino.clear();
        Thread.sleep(3000);
        By localizadorDestino = By.xpath(" //div[.//label[@id=':Rqhj9lalamt2mm:-label'][contains(., 'Destino')]]/input");
        click(esperarXElementoLocalizado(localizadorDestino));
        Thread.sleep(3000);
        escribirTexto(localizadorDestino, "Roma");
        Thread.sleep(3000);
    }
    public void FechaDeIda() throws InterruptedException {
        By localizadorFechaSalida = By.xpath("//button[@aria-label='Fecha de ida']//span");
        click(localizadorFechaSalida);
        Thread.sleep(3000);
        By diaSalida = By.xpath("//div//div[.//span[@id='10']]//button[contains(text(), '14')]");
        click(diaSalida);
    }
    public void FechaDeVuelta(){
    }

    public void CantidadPasajeros(){
    }
    public void localizar(){
        By localizadorBtnBuscar = By.xpath("//button[@type='submit']");
        click(localizadorBtnBuscar);
    }



}