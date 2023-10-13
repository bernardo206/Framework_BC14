package aut.testcreation.testcases.TestRumbo;

import framework.engine.selenium.SeleniumWrapper;
import org.junit.jupiter.api.Test;

import aut.testcreation.pages.BernardoPages.HomePage;
import aut.testcreation.pages.BernardoPages.RegisterPage;
import aut.testcreation.pages.Bootcamp14pages.HomePageRumbo;
import aut.testcreation.pages.Bootcamp14pages.HotelPage.HotelPage;
import aut.testcreation.pages.Bootcamp14pages.TrenPage.TrenPage;
import aut.testcreation.pages.Bootcamp14pages.TrenPage.formularioTren;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;


public class testTren extends SeleniumWrapper {


    //ATRIBUTOS

    WebDriver driver;
    HomePageRumbo home;

    HotelPage hotelPage;
    TrenPage tren;
    formularioTren formularioT;


    String rutaDriver = "C:\\Users\\bernardo.estrada\\OneDrive - TSOFT\\Escritorio\\BOOTCAMP\\SEMANA 1\\17 DE AGOSTO NIVELACION\\CODIGOS Y EJERCICIOS\\Selenium_Bernardo_Estrada\\src\\test\\resources\\drivers\\chromedriver.exe";
    String browser = "Chrome";

    String property = "webdriver.chrome.driver";


    public testTren(WebDriver driver) {
        super(driver);
    }


    @BeforeEach
    public void preTest() {

        home = new HomePageRumbo(driver);
        home.conexionDriver(browser, rutaDriver, property);

        hotelPage = new HotelPage(home.getDriver());
        tren = new TrenPage(home.getDriver());
        formularioT = new formularioTren(tren.getDriver());
        home.cargarPagina("https://www.rumbo.es/");


    }

<<<<<<< HEAD
    @Test
    public void CP_ReservaTrenIda() {  //no elijo cant pasajero, lo hace con 2 que es la opcion recomendada. Lo mismo con la fecha.
        //en la parte de datos llego hasta completar los datos de la persona y que se valide, no completo los datos del pasajero ni clickeo siguiente
=======
@Test
public void CP_ReservaTrenIda(){  //no elijo q pasajero, lo hace con 2 que es la opcion recomendada
>>>>>>> 8dacfcc911f30117bc43dd8887c36ddc4ee23663
        home.aceptarCookies();
        home.locatorVerMas();
        home.btnTrenes();
        tren.locatorIda();
        tren.locatorOrigen("Madrid");
        tren.locatorDestino();
        tren.btnBuscar();
        tren.locatorPrimerTren();
        tren.aceptarPrimerTren();
<<<<<<< HEAD
        formularioT.formularioDatos("carlos", "perez", "probando@gmail.com", 234343434);
        // formularioT.formulacioPasajero("Roberto","Garcia",14,2000,"123456789b");
=======
        formularioT.formularioDatos("carlos","perez","probando@gmail.com", 234343434);
        formularioT.formulacioPasajero("Roberto","Garcia",14,1988,"123456789b");
>>>>>>> 8dacfcc911f30117bc43dd8887c36ddc4ee23663

        Assertions.assertTrue(true);
    }

    @Test
    public void CP_ReservaTren_DestinoNoDisponible() {
        home.aceptarCookies();
        home.locatorVerMas();
        home.btnTrenes();
        tren.locatorIda();
        tren.errorOrigen("Mar del Plata");

        Assertions.assertTrue(true);
    }

    @Test
    public void CP_ReservaTren_idaVuelta() {  //elijo predeterminado fechas y pasajeros,llego hasta completar datos pasajero y click en seguro
        home.aceptarCookies();
        home.locatorVerMas();
        home.btnTrenes();
        tren.locatorIdaVuelta();
        tren.locatorOrigen("Madrid");
        tren.locatorDestino();
        tren.btnBuscar();
        tren.PrimerTrenIdayVuelta();
        tren.aceptarPrimerTren();
        formularioT.formularioDatos("carlos", "perez", "probando@gmail.com", 234343434);
        //formularioT.formulacioPasajero("Roberto","Garcia",14,2000,"123456789b");
        formularioT.seguro();

        Assertions.assertTrue(true);
    }

    @Test
    public void CP_ReservaTrenHotel() {  //no elijo q pasajero, lo hace con 2 que es la opcion recomendada. Lo mismo con la fecha.
        //en la parte de datos llego hasta completar los datos de la persona y que se valide, no completo los datos del pasajero ni clickeo siguiente
        home.aceptarCookies();
        home.locatorVerMas();
        home.btnTrenHotel();
        tren.locatorOrigen("Madrid");
        tren.locatorDestino();
        tren.btnBuscar();
        Assertions.assertTrue(true);
    }
}