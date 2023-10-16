package aut.testcreation.pages.Bootcamp14pages;


import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.Set;

 public class CheckoutTarjeta extends SeleniumWrapper {
    public CheckoutTarjeta(WebDriver driver) {
        super(driver);
    }
    By locatorPais = By.xpath("//i[normalize-space()='arrow_drop_down']");

    By locatorCheckbox = By.xpath("//div[@class='q-checkbox__bg absolute']//*[name()='svg']");

    By locatorComprar = By.xpath("//span[contains(text(),'Comprar')]");

    public void DatosPersonales(String nombre, String apellido, String email, String calle, String ciudad, String cp, String provincia, String telefono) throws InterruptedException {
        Thread.sleep(3000);
        By name = By.xpath("//input[@name='name']");
        write(nombre, name);
        Thread.sleep(2000);
        By surname = By.xpath("//input[@name='surname']");
        write(apellido, surname);
        Thread.sleep(2000);
        By mail = By.xpath("//input[@aria-label='Correo electrónico']");
        write(email, mail);
        Thread.sleep(2000);
        By direccion = By.xpath("//input[@aria-label='Calle']");
        scroll(direccion);
        write(calle, direccion);
        Thread.sleep(2000);
        By city = By.xpath("//input[@aria-label='Ciudad']");
        write(ciudad, city);
        Thread.sleep(2000);
        By codigoPostal = By.xpath("//input[@aria-label='Código postal']");
        write("555789", codigoPostal);
        Thread.sleep(2000);
        By province = By.xpath("//input[@aria-label='Provincia']");
        write(provincia, province);
        Thread.sleep(2000);
        By phone = By.xpath("//input[@aria-label='Número de teléfono']");
        write(telefono, phone);
        Thread.sleep(2000);

    }
    public void seleccionarPais(String pais) {
        try {
            click(esperarXElementoLocalizado(locatorPais));

            WebElement listaDesplegable = driver.findElement(By.xpath("//div[@class='q-field__native row items-center']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", listaDesplegable);

            Thread.sleep(2000);  // Espera opcional si es necesario

            By paisSelector = By.xpath("//span[text()='" + pais + "']");
            click(paisSelector);
            Thread.sleep(2000);  // Espera opcional después de seleccionar el país
        } catch (Exception e) {
            // Manejar la excepción adecuadamente, por ejemplo, registrándola o tomando acciones específicas
        }
    }

    public void Checkbox() throws InterruptedException {
        click(esperarXElementoLocalizado(locatorCheckbox));
        Thread.sleep(2000);
    }

    public void Comprar() throws InterruptedException {
        click(esperarXElementoLocalizado(locatorComprar));
        Thread.sleep(2000);
    }

}

