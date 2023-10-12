package aut.testcreation.pages.Bootcamp14pages;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.Set;

public class ContactoPageRumbo extends SeleniumWrapper {
    public ContactoPageRumbo(WebDriver driver) {
        super(driver);
    }

    public void completarDatosContacto() throws InterruptedException {
        Thread.sleep(3000);
        By nombre = By.xpath("//input[@name='name']");
        write("Juan", nombre);
        By apellido = By.xpath("//input[@name='surname']");
        write("Perez", apellido);
        By email = By.xpath("//input[@name='email']");
        write("elasdelaspruebasautomatizadas@yahoo.com.es", email);
        By telefono = By.xpath("//input[@name='phone']");
        write("2223333444", telefono);
        By direccion = By.xpath("//input[@name='address']");
        scroll(direccion);
        write("mi calle", direccion);
        By numeroCasa = By.xpath("//input[@name='houseNumber']");
        write("123", numeroCasa);
        By codigoPostal = By.xpath("//input[@name='postCode']");
        write("7000", codigoPostal);
        By ciudad = By.xpath("//input[@name='city']");
        write("Barcelona", ciudad);
        By sexo =By.xpath("//*[@id='radio-groups.1.travellers.1.title-MALE-label']");
        click(sexo);
        Thread.sleep(2000);
        By dia = By.xpath("//input[@name='groups.1.travellers.1.dateOfBirth']");
        scroll(dia);
        write("10" , dia);
        By mes = By.xpath("//span[@class='FormFieldstyles__AdornmentWrapper-sc-1pt5zgp-5 TKzFh']");
        clickearPorPos(mes, 11);
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            driver.switchTo().window(handle);
            By enero = By.xpath("//span[contains(text(),'enero')]");
            click(enero);
        }
        String mainWindowHandle = driver.getWindowHandle();
        driver.switchTo().window(mainWindowHandle);
        By anio = By.xpath("//span[.//input][.//span[contains(text(),'Año')]]/input");
        write("2000", anio);
    }
    public void selecionaEquipaje(){
        By equipaje =By.xpath("//input[@data-testid='radio-input']");
        clickearPorPos(equipaje,0);
    }
    public void confirma(){
        By btnSiguiente = By.xpath("//button[contains(text(),'Siguiente')]");
        click(btnSiguiente);
    }

    public boolean detectaFaltaSelecionEquipaje() {
        By faltaEquipaje = By.xpath("/div[contains(text(),'Seleccionar una opción')]");
        boolean existe;
        if (faltaEquipaje != null) {
            return true;
        }
        return false;
    }

}
