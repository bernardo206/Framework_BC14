package aut.testcreation.pages.Bootcamp14pages;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ParticularPage extends SeleniumWrapper {
    public ParticularPage(WebDriver driver) {
        super(driver);
    }

    By locatorImporte = By.xpath("//div[@class='row full-width justify-center items-center order-item-container']//div[3]//div[1]");
    By locatorImprimirTarjeta = By.xpath("//div[@id='shipping-method-container']//div[3]//div[2]//div[2]");
    By locatorDestinatario = By.xpath("//input[@class='q-field__native q-placeholder' and @aria-label='Nombre']");
    By locatorCorreo = By.xpath("//input[@class='q-field__native q-placeholder' and @aria-label='Dirección de correo electrónico']");
    By locatorRemitente = By.xpath("//input[@class='q-field__native q-placeholder' and @aria-label='Remitente']");

    By locatorAñadir = By.xpath("//button[@class='q-btn q-btn-item non-selectable no-outline q-btn--outline q-btn--rectangle text-primary q-btn--actionable q-focusable q-hoverable q-btn--no-uppercase full-width']//span[@class='q-btn__content text-center col items-center q-anchor--skip justify-center row']");

    public void Importe() {
        click(esperarXElementoLocalizado(locatorImporte));
    }
    public void Imprimir() {
        click(esperarXElementoLocalizado(locatorImprimirTarjeta));
    }

    public void Destinatario() {
        escribirTexto(esperarXElementoLocalizado(locatorDestinatario), "Armando");
    }



    public void correo() {
        escribirTexto(esperarXElementoLocalizado(locatorCorreo), "armando@gmail.com");}

    public void Remitente() {
        escribirTexto(esperarXElementoLocalizado(locatorRemitente), "Rojas");}

    public void Añadir(){
        click(esperarXElementoLocalizado(locatorAñadir));
    }

    public void Continuar()  {
        By locatorBtnContinuar = By.xpath("//span[contains(text(),'Continuar')]");


    }


}