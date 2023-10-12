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

    By locatorSr = By.xpath("//*[@id='radio-groups.1.travellers.1.title-MALE-label']");
    By locatorNombrePasajero = By.xpath("//input[@name='groups.1.travellers.1.name']");

    By locatorApellidoPasajero = By.xpath("//input[@name='groups.1.travellers.1.surname']");

    By locatorDiaCumpleanios = By.xpath("//input[@data-testid='input-input' and @pattern='[0-9]{1,2}' and @maxlength='2' and @aria-invalid='false' and @type='tel' and @name='groups.1.travellers.1.dateOfBirth']");
    By locatorMesCumpleanios = By.xpath("//button[@data-testid='groups.1.travellers.1.dateOfBirth_month']");
    By locatorFebrero = By.xpath("//span[text()='febrero']");
    //By locatorMesCumpleanios = By.xpath("//input[@type='text' and @aria-label='search-input' and contains(@id, 'select-field-search-input')]");
    By locatorAnioCumpleanios = By.xpath("//span[.//input][.//span[contains(text(),'Año')]]/input");
    By locatorDNI = By.xpath("//input[@name='groups.1.travellers.2.documentNumber']");
    By btnFullFlex = By.xpath("//button[@id='special-assistance-checkbox' and @role='checkbox']");
    By btnSiguiente = By.xpath("//button[normalize-space()='Siguiente']");
    By locatorTipoDocumento = By.xpath("//button[.//span[text()='Tipo de documento']]");
    By locatorSeleccionDNI = By.xpath("//li[.//span[text()='DNI']]");
    By locatorDNIOpcion = By.xpath("//button[@data-testid='groups.1.travellers.1.documentType' and @aria-haspopup='listbox' and contains(@class, 'FormFieldstyles__InnerWrapper-sc-1pt5zgp-3') and contains(@class, 'Selectstyles__InnerWrapper-sc-d5yk3i-2') and contains(@class, 'fUwskt') and contains(@class, 'dNHwnH')]");
    By DNIopcion = By.xpath("//span[contains(@class, 'MenuItemstyles__Label-sc-fguzn7-1') and text()='DNI']");


    public void formularioDatos(String nombre, String apellido, String mail, Integer telefono) {
        escribirTexto(esperarXElementoLocalizado(locatorNombre), nombre);
        escribirTexto(esperarXElementoLocalizado(locatorApellido), apellido);
        escribirTexto(esperarXElementoLocalizado(locatorMail), mail);
        escribirTexto(esperarXElementoLocalizado(locatorTelefono), String.valueOf(telefono));

        //Assertions.assertEquals(resultadoEsperado,obtenerTexto(esperarPorElementoLocalizado(locatorErrorContrasenia)));
        // click(esperarPorElementoLocalizado(locatorIngresar));
    }

    public void formulacioPasajero(String nombrePasajero, String apellidoPasajero, Integer diaCumpleanios, Integer anioCumpleanios,  String dni){
        click(esperarXElementoLocalizado(locatorSr));
        escribirTexto(esperarXElementoLocalizado(locatorNombrePasajero), nombrePasajero);
        escribirTexto(esperarXElementoLocalizado(locatorApellidoPasajero), apellidoPasajero);
        escribirTexto(esperarXElementoLocalizado(locatorDiaCumpleanios), String.valueOf(diaCumpleanios));
        click(esperarXElementoLocalizado(locatorMesCumpleanios));
        esperarXSegundos(2000);
        click(esperarXElementoLocalizado(locatorFebrero));
        esperarXSegundos(2000);
        escribirTexto(esperarXElementoLocalizado(locatorAnioCumpleanios), String.valueOf(anioCumpleanios));
        click(esperarXElementoLocalizado(locatorTipoDocumento));
        esperarXSegundos(2000);
        click(esperarXElementoLocalizado(locatorSeleccionDNI));
        esperarXSegundos(2000);
        //click(esperarPorElementoLocalizado(locatorDNIOpcion));
        //click(esperarPorElementoLocalizado(DNIopcion));

        escribirTexto(esperarXElementoLocalizado(locatorDNI),dni);

        // WebElement menuButtonDNI = getDriver().findElement(By.id("//*[@id='root']/div/div[2]/div/div/div[2]/div[5]/form/section[1]/section/div/div[1]/div/button/span[1]"));
        // menuButtonDNI.click();
        // WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        //WebElement menuOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("//span[normalize-space()='DNI']")));
        //menuOption.click();



        click(esperarXElementoLocalizado(btnFullFlex));
        esperarXSegundos(2000);
        click(esperarXElementoLocalizado(btnSiguiente));
    }
    public formularioTren(WebDriver driver) {
        super(driver);
    }
}
