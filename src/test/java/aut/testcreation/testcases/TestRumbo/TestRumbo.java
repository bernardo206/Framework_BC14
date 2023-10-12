package aut.testcreation.testcases.TestRumbo;

import aut.testcreation.pages.BernardoPages.HomePage;
import aut.testcreation.pages.BernardoPages.RegisterPage;
import aut.testcreation.pages.Bootcamp14pages.HomePageRumbo;
import aut.testcreation.pages.Bootcamp14pages.HotelPage.HotelPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;


public class TestRumbo {


        //ATRIBUTOS

        WebDriver driver;
        HomePageRumbo home ;

        HotelPage hotelPage;
        String rutaDriver = "C:\\Users\\bernardo.estrada\\OneDrive - TSOFT\\Escritorio\\BOOTCAMP\\SEMANA 1\\17 DE AGOSTO NIVELACION\\CODIGOS Y EJERCICIOS\\Selenium_Bernardo_Estrada\\src\\test\\resources\\drivers\\chromedriver.exe";
        String browser = "Chrome";

        String property = "webdriver.chrome.driver";


        @BeforeEach
        public void preTest(){

            home = new HomePageRumbo(driver);
            home.conexionDriver(browser,rutaDriver,property);

            hotelPage = new HotelPage(home.getDriver());
            home.cargarPagina("https://www.rumbo.es/");

        }


    @Test
    public void CP001_Reserva_hotel_ok(){

        home.aceptarCookies();
        hotelPage.completarCamposBusquedaHoteles("Barcelona");


    }





          @AfterEach
          public void afterTest(){
        home.cerrarBrowser();
    }







    }
