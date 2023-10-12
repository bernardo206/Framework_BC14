package aut.testcreation.pages.Bootcamp14pages.TrenPage;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TrenPage extends SeleniumWrapper {

    By locatorIda = By.xpath("//div[contains(text(),'Solo ida')]");
    By btnBuscar = By.xpath("//button[@aria-label='Buscar']");
    By locatorPrimerTren = By.xpath("//div[@class='FullTransportSummary__SummaryColumn-sc-aaxr6w-0 jegcUp']//div[@data-testid='transportcard-way-0']");
    By aceptarPrimerTren = By.xpath("//button[contains(@class, 'TripCardBookButton__BrgUiBootstrapSizedButton-sc-byk9tx-0')]");

    public TrenPage(WebDriver driver) {
        super(driver);
    }

    public void locatorIda() {
        click(esperarXElementoLocalizado(locatorIda));
    }

    public void locatorPrimerTren() {
        click(esperarXElementoLocalizado(locatorPrimerTren));
    }

    public void btnBuscar() {
        click(esperarXElementoLocalizado(btnBuscar));
    }

    public void aceptarPrimerTren() {
        click(esperarXElementoLocalizado(aceptarPrimerTren));
    }

    public void locatorOrigen() {
        WebElement origenInput = getDriver().findElement(By.xpath("//*[@id=':Rb8qjalamt2mm:']"));
        origenInput.sendKeys("Madrid");
        esperarXSegundos(2000);
        WebElement opcionOrigen = getDriver().findElement(By.xpath("//*[@id=':Rb8qjalamt2mm:-option-0']"));
        opcionOrigen.click();
        esperarXSegundos(1000);
    }

    public void locatorDestino() {
        WebElement destinoInput = getDriver().findElement(By.xpath("//input[@id=':Rd8qjalamt2mm:' and @aria-label='Destino']"));
        destinoInput.sendKeys("Barcelona");
        esperarXSegundos(3000);
        WebElement opcionDestino = getDriver().findElement(By.xpath("//*[@id=':Rd8qjalamt2mm:-option-0']"));//li[@id=':Rb8qjalamt2mm:-option-0']
        opcionDestino.click();
        esperarXSegundos(1000);

    }


    public void fechaIda() {
        WebElement fechaIda = getDriver().findElement(By.id("//span[@class = 'd-aziqil']"));
        fechaIda.click();
        esperarXSegundos(2000);

        WebElement fechaDeseada = getDriver().findElement(By.xpath("//span[@id='10']//button[normalize-space()='14']"));
        fechaDeseada.click();
    }

}