package aut.testcreation.pages.Bootcamp14pages.TrenPage;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TrenPage extends SeleniumWrapper {

    By locatorIda =  By.xpath("//div[contains(text(),'Solo ida')]");
    By btnBuscar = By.xpath("//button[@aria-label='Buscar']");
    By locatorPrimerTren = By.xpath("//div[contains(@class, 'FullTransportWay__SummaryGrid-sc-acha5w-1')]");
    //div[@class='FullTransportSummary__SummaryColumn-sc-aaxr6w-0 jegcUp']//div[@data-testid='transportcard-way-0']");
    By aceptarPrimerTren = By.xpath("//button[contains(@class, 'TripCardBookButton__BrgUiBootstrapSizedButton-sc-byk9tx-0')]");
    By primerTrenIdayVuelta = By.xpath("//*[@id=\"app-container\"]/div/div/div/div/div[1]/div[2]/div[3]/div/div[2]/div[5]/div/section[2]/div/div[1]/div/div/div/div[2]/div/div[1]");
    By btnCantidadPasajeros = By.xpath("//*[@id='hub-csw-container']/div/div/form/div[2]/div[3]/div/div/div/button");
    By cantidadPasajeros = By.xpath("//svg[@width='1em' and @height='1em']/path[contains(@d, 'M19 13H5V11H19V13Z')]");

    By locatorOrigen = By.xpath("//*[@id=':ra:'");
    //*[@id=':Rb8qjalamt2mm:']");
    By errorOrigen = By.xpath("//span[@role='alert' and contains(@class, 'd-18hlxxm') and text()='Selecciona ciudad de origen']");
    //By locatorOrigen = By.xpath("//*[@id=':Rb8qjalamt2mm:']");
    //By madrid = By.xpath("//ul[@class='d-1wtoxx4']/li[.='Madrid']");
    By locatorIdaVuelta = By.xpath("//div[@class='d-4mhg59' and text()='Ida y vuelta']");
    By locatorFechaIngreso = By.cssSelector("button[aria-label='Fecha de entrada']");

    By locatorBoton18 = By.xpath("//button[text()='18']");

    By locatorBoton22 = By.xpath("//button[text()='22']");

    //Reducir adultos
    By botonReducirAdultos = By.className("d-9hyv4y");
    By salirDeBotonReducirAdultos = By.cssSelector("input[aria-label='Buscar alojamiento en']");

    public TrenPage(WebDriver driver) {
        super(driver);
    }


    //By locatorDestino = By.xpath("//input[@id=':Rd8qjalamt2mm:' and @aria-label='Destino']");
    public void locatorIda(){
        click(esperarXElementoLocalizado(locatorIda));
    }
    public void locatorIdaVuelta(){
        click(esperarXElementoLocalizado(locatorIdaVuelta));
    }
    public void locatorPrimerTren(){
        click(esperarXElementoLocalizado(locatorPrimerTren));
    }
    public void PrimerTrenIdayVuelta(){
        click(esperarXElementoLocalizado(primerTrenIdayVuelta));
    }
    public void btnBuscar(){
        click(esperarXElementoLocalizado(btnBuscar));
    }
    public void aceptarPrimerTren(){
        click(esperarXElementoLocalizado(aceptarPrimerTren));
    }
    public void locatorOrigen(String origen){
        WebElement origenInput = getDriver().findElement(By.xpath("//*[@id=':Rb8qjalamt2mm:']"));
        origenInput.sendKeys(origen);
        esperarXSegundos(3000);
        WebElement opcionOrigen = getDriver().findElement(By.xpath("//*[@id=':Rb8qjalamt2mm:-option-0']"));
        opcionOrigen.click();
        esperarXSegundos(2000);


    }
    public void errorOrigen(String origen){
        escribirTexto(esperarXElementoLocalizado(locatorOrigen),origen);
        esperarXSegundos(1000);
        enter(locatorOrigen);
        esperarXSegundos(2000);
        esperarXElementoLocalizado(errorOrigen);
    }
    public void locatorDestino(){

        WebElement destinoInput = getDriver().findElement(By.xpath("//input[@id=':Rd8qjalamt2mm:' and @aria-label='Destino']"));
        destinoInput.sendKeys("Barcelona");
        esperarXSegundos(3000);
        WebElement opcionDestino = getDriver().findElement(By.xpath("//*[@id=':Rd8qjalamt2mm:-option-0']"));//li[@id=':Rb8qjalamt2mm:-option-0']
        opcionDestino.click();
        esperarXSegundos(2000);

    }
}