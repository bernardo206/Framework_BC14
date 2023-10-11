package aut.testcreation.pages.Bootcamp14pages.HotelPage;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;

import static org.openqa.selenium.By.cssSelector;

public class HotelPage extends SeleniumWrapper {


    public HotelPage(WebDriver driver) {
        super(driver);
    }





    // DEFINIR LOCALIZADORES-----------------------------------------------------------------------


    By locatorBotonHoteles = By.xpath("//span[contains(text(), 'Hoteles')]");

    // Donde ir o destino
    By locatorDondeIr = By.cssSelector("input[aria-label='Buscar alojamiento en']");

    //Calendario entrada y salida
    By locatorFechaIngreso = By.cssSelector("button[aria-label='Fecha de entrada']");

    By locatorBoton18 = By.xpath("//button[text()='18']");

    By locatorBoton22 = By.xpath("//button[text()='22']");

    //Reducir adultos
    By botonReducirAdultos = By.className("d-9hyv4y");

    By salirDeBotonReducirAdultos = By.cssSelector("input[aria-label='Buscar alojamiento en']");


    //BotonBuscar
    By botonBuscar = By.cssSelector("div.d-acz6lr");



    // CENTRALIZAR ACCIONES------------------------------------------------------------------------



    public void completarCamposBusquedaHoteles(String Lugar) {

        click(esperarXElementoLocalizado(locatorBotonHoteles));
        esperarXSegundos(2000);



        WebElement dondeIrElement = esperarXElementoLocalizado(locatorDondeIr);
        escribirTexto(dondeIrElement, Lugar);
        esperarXSegundos(2000);
        dondeIrElement.clear();
        esperarXSegundos(2000);




        click(esperarXElementoLocalizado(locatorFechaIngreso));
        esperarXSegundos(2000);
        click(locatorBoton18);
        click(locatorBoton22);
        esperarXSegundos(2000);


        click(botonReducirAdultos);
        esperarXSegundos(2000);
        click(salirDeBotonReducirAdultos);
        escribirTexto(dondeIrElement, Lugar);
        esperarXSegundos(2000);
        dondeIrElement.clear();
        esperarXSegundos(2000);


        click(botonBuscar);
      esperarXSegundos(12000);




    }
}