package framework.engine.selenium;

import lombok.Getter;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

@Getter
public class SeleniumWrapper {

    protected WebDriver driver;
    private WebDriverWait espera;
    private JavascriptExecutor js;

    //Constructor Base
    public SeleniumWrapper(WebDriver driver){
        this.driver = driver;
    }




    //Wrappers Selenium
    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }


    public List<WebElement> findElements (By locator){
        return driver.findElements(locator);
    }




    public String getText (By locator){
        return driver.findElement(locator).getText();
    }



    public void write(String inputText, By locator){
        driver.findElement(locator).sendKeys(inputText);
    }



    public void sendKeys(Keys key, By locator){
        driver.findElement(locator).sendKeys(key);
    }


    public String isDisplayed2(By locator) {
        return (String) ((JavascriptExecutor) driver).executeScript("alert('La fecha seleccionada está deshabilitada.');");

   }

    public void dobleClick(By localizador) {
        Actions act = new Actions(driver);
        WebElement ele = driver.findElement(localizador);
        act.doubleClick(ele).perform();
    }

    public void scroll(By localizador) {
        WebElement elemento = driver.findElement(localizador);
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", elemento);

    }


    public Boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }






    public Boolean isEnabled(By locator) {
        try {
            return driver.findElement(locator).isEnabled();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }



    public Boolean isSelected(By locator) {
        try {
            return driver.findElement(locator).isSelected();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }


    public void navigateTo(String url){
        driver.navigate().to(url);
    }


    public String getUrlTitle(){
        return driver.getTitle();
    }





    // METODOS----------------------------------------------------------------------------

    // --------Getters and Setters---------------------------------


// WRAPPER DE LAS ACCIONES DE SELENIUM------------------------------------------------

    public void click(By localizador){
        driver.findElement(localizador).click();
    }
    public WebDriver getDriver() {
        return driver;
    }

    public void click(WebElement element){
        element.click();
    }



    public void escribirTexto(By localizador, String texto){
        driver.findElement(localizador).sendKeys(texto);
    }

    public void escribirTexto(WebElement element, String texto){
        element.sendKeys(texto);
    }

    public WebElement buscarElementoWeb(By localizador){
        return  driver.findElement(localizador);
    }

    public List<WebElement> buscarElementosWeb(By localizador){
        return driver.findElements(localizador);
    }


    public void esperarXSegundos (int milisegundos)  {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            //   throw new RuntimeException(e);
            System.out.println("ups");
        }
    }

    public void cargarPagina(String url){
        driver.get(url);
    }



    //Driver que espera 20 milisegundos hasta que aparece un elemento, consulta cada 0.5 seg la condicion esperada --(ExpectedCondicions)--
    public WebElement esperarXElementoLocalizado(By localizador){
        espera = new WebDriverWait(this.getDriver(),20);
        return espera.until(ExpectedConditions.presenceOfElementLocated(localizador));

    }

    public String obtenerTexto(By localizador){
        return driver.findElement(localizador).getText();
    }


    public String obtenerTexto(WebElement element){
        return element.getText();
    }


    public void maximizarBrowser(){
        driver.manage().window().maximize();
    }

    public void cerrarBrowser(){
        driver.quit();
    }


    public WebDriver conexionDriver(String browser, String ruta, String property){
        if (browser.equalsIgnoreCase("Chrome")){
            System.setProperty(property,ruta);
            this.driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")){
            System.setProperty(property,ruta);
            this.driver = new FirefoxDriver();
        }
        return this.driver;
    }




    public void  seleccionarComboBoxPorValor(By localizador, String value){

        Select selectDia = new Select(esperarXElementoLocalizado(localizador));
        selectDia.selectByValue(value);

    }

    public void  seleccionarComboBoxPorTextoVisible(By localizador, String texto){

        Select selectDia = new Select(esperarXElementoLocalizado(localizador));
        selectDia.selectByVisibleText(texto);

    }

    public void clickearPorPos(By localizador, int pos){
        List<WebElement> lista = buscarElementosWeb(localizador);
        WebElement elemento= (lista.get(pos));
        click(elemento);
    }


    public void selecionarPorLocalizador(By localizador){
        Select elemento = new Select(esperarXElementoLocalizado(localizador));

    }
    public void  seleccionarComboBoxPorContainsTexto(By localizador, String texto){
        Select elemento = new Select(esperarXElementoLocalizado((By.xpath("//*[contains(text(), '" + texto + "')]"))));
    }



    public void writePorPos(String inputText, By locator , int pos){
        List<WebElement> lista = buscarElementosWeb(locator);
        WebElement elemento= (lista.get(pos));
        elemento.sendKeys(inputText);
    }
/*
    public void seleccionarComboPorPos(By localizador , int pos){
        Select elemento = new Select(esperarXElementoLocalizado((By.xpath("//*[contains(text(), '" + texto + "')]"))));
    }
*/


    public void enter(By localizador) {
        driver.findElement(localizador).submit();
    }

}
