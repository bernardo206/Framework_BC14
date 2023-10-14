package aut.testcreation.pages.Bootcamp14pages.TrenPage;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class formularioTren extends SeleniumWrapper {
    By locatorNombre = By.xpath("//input[@name='name']");
    //span[contains(@class, 'FormFieldstyles__ValueWrapper')]/input[@data-testid='input-input' and @name='name']");
    By locatorApellido = By.xpath("//input[@name='surname']");
    //span[contains(@class, 'FormFieldstyles__ValueWrapper')]/input[@data-testid='input-input' and @name='surname']");
    By locatorMail = By.xpath("//input[@name='email']");
    By locatorTelefono = By.xpath("//input[@name='phone']");


    By btnFullFlex = By.xpath("//button[@id='special-assistance-checkbox' and @role='checkbox']");
    By btnSiguiente = By.xpath("//button[normalize-space()='Siguiente']");
    By locatorTipoDocumento = By.xpath("//button[.//span[text()='Tipo de documento']]");
    By locatorSeleccionDNI = By.xpath("//li[.//span[text()='DNI']]");
    By locatorDNIOpcion = By.xpath("//button[@data-testid='groups.1.travellers.1.documentType' and @aria-haspopup='listbox' and contains(@class, 'FormFieldstyles_InnerWrapper-sc-1pt5zgp-3') and contains(@class, 'Selectstyles_InnerWrapper-sc-d5yk3i-2') and contains(@class, 'fUwskt') and contains(@class, 'dNHwnH')]");
    By DNIopcion = By.xpath("//span[contains(@class, 'MenuItemstyles__Label-sc-fguzn7-1') and text()='DNI']");
    By locatorSeguro =By.xpath ("//span[@class='check']");

    public void formularioDatos(String nombre, String apellido, String mail, Integer telefono) {
        escribirTexto(esperarXElementoLocalizado(locatorNombre), nombre);
        escribirTexto(esperarXElementoLocalizado(locatorApellido), apellido);
        escribirTexto(esperarXElementoLocalizado(locatorMail), mail);
        escribirTexto(esperarXElementoLocalizado(locatorTelefono), String.valueOf(telefono));

        //Assertions.assertEquals(resultadoEsperado,obtenerTexto(esperarPorElementoLocalizado(locatorErrorContrasenia)));
        // click(esperarPorElementoLocalizado(locatorIngresar));
    }

    public void seguro(){
        click(esperarXElementoLocalizado(locatorSeguro));
    }

    public formularioTren(WebDriver driver) {
        super(driver);
    }
}