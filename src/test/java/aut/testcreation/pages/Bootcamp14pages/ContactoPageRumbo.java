package aut.testcreation.pages.Bootcamp14pages;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.Set;

public class ContactoPageRumbo extends SeleniumWrapper {
    public ContactoPageRumbo(WebDriver driver) {
        super(driver);
    }

    public void completarDatosContacto(String nombre, String apellido, String email, String telefono, String calle, int numero , String cp, String ciudad, String dia, String mes, String anio) throws InterruptedException {
        Thread.sleep(3000);
        By name = By.xpath("//input[@name='name']");
        write(nombre, name);
        By surname = By.xpath("//input[@name='surname']");
        write(apellido, surname);
        By mail = By.xpath("//input[@name='email']");
        write(email, mail);
        By phone = By.xpath("//input[@name='phone']");
        write(telefono, phone);
        By direccion = By.xpath("//input[@name='address']");
        scroll(direccion);
        write(calle, direccion);
        By numeroCasa = By.xpath("//input[@name='houseNumber']");
        write("123", numeroCasa);
        By codigoPostal = By.xpath("//input[@name='postCode']");
        write("7000", codigoPostal);
        By city = By.xpath("//input[@name='city']");
        write(ciudad, city);
        By sexo =By.xpath("//*[@id='radio-groups.1.travellers.1.title-MALE-label']");
        click(sexo);
        Thread.sleep(2000);
        By date = By.xpath("//input[@name='groups.1.travellers.1.dateOfBirth']");
        scroll(date);
        write(dia , date);
        By month = By.xpath("//button[@data-testid='groups.1.travellers.1.dateOfBirth_month']//span[1]");
        click(month);
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            driver.switchTo().window(handle);
            By elejido = By.xpath("//span[contains(text(),"+mes+")]");
            click(elejido);
        }
        String mainWindowHandle = driver.getWindowHandle();
        driver.switchTo().window(mainWindowHandle);
        By year = By.xpath("//span[.//input][.//span[contains(text(),'Año')]]/input");
        write(anio, year);
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
