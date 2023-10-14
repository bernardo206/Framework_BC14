package aut.testcreation.pages.Bootcamp14pages;



import framework.engine.selenium.SeleniumWrapper;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;

public class HomeTarjeta extends SeleniumWrapper {
    public HomeTarjeta(WebDriver driver) {
        super(driver);
    }


    By locatorBtnTarjetaRegalo =By.xpath("//div[@class='MenuLinkstyled__MenuTextWrapper-sc-1dkmpyp-4 KZClY' and text()='Tarjeta Regalo']");


    public void BtnTarjetaRegalo(){
        click(esperarXElementoLocalizado(locatorBtnTarjetaRegalo));
    }

}
