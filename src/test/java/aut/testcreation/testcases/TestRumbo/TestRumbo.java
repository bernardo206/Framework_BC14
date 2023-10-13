package aut.testcreation.testcases.TestRumbo;
import aut.testcreation.pages.Bootcamp14pages.*;
import aut.testcreation.pages.Bootcamp14pages.HotelPage.HotelPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;


public class TestRumbo {


    //ATRIBUTOS

    WebDriver driver;
    HomePageRumbo home;
    VuelosPageRumbo vuelosPage;
    ContactoPageRumbo contacto;
    SeguroPageRumbo seguro;
    ConfirmacionPageRumbo confirmacion;
    HotelPage hotelPage;
    String rutaDriver = "C:\\Users\\bernardo.estrada\\OneDrive - TSOFT\\Escritorio\\BOOTCAMP\\SEMANA 1\\17 DE AGOSTO NIVELACION\\CODIGOS Y EJERCICIOS\\Selenium_Bernardo_Estrada\\src\\test\\resources\\drivers\\chromedriver.exe";
    String browser = "Chrome";
    String property = "webdriver.chrome.driver";


    @BeforeEach
    public void preTest() {

        home = new HomePageRumbo(driver);
        home.conexionDriver(browser, rutaDriver, property);
        vuelosPage = new VuelosPageRumbo(home.getDriver());
        contacto = new ContactoPageRumbo(vuelosPage.getDriver());
        seguro = new SeguroPageRumbo(contacto.getDriver());
        confirmacion = new ConfirmacionPageRumbo(seguro.getDriver());
        hotelPage = new HotelPage(home.getDriver());
        home.cargarPagina("https://www.rumbo.es/");
    }
    @AfterEach
    public void afterTest(){
        home.cerrarBrowser();
    }

    @Test
    public void CP0012_Reserva_vuelo_solo_ida_OK() throws InterruptedException {
        home.aceptarCookies();
        home.ingresarOrigen();
        home.ingresarDestino();
        home.seleccionarVueloSoloIda();
        home.ingresarFechaSalida();
        home.buscar();
        vuelosPage.seleccionarVuelo();
        vuelosPage.confirmarVuelo();
        vuelosPage.elegirTarifa("Elegir Classic");
        contacto.completarDatosContacto("Juan", "Perez", "elasdelaspruebasautomatizadas@yahoo.com.es", "2224545454", "mi calle", 1234, "70000", "Barcelona", "10", "enero", "2000");
        contacto.selecionaEquipaje();
        contacto.confirma();
        seguro.seleccionarSeguro();
        seguro.confirmarSeguro();
        Boolean resultadoEsperado = true;
        Boolean resultadoObtenido = confirmacion.confirmacion();
        Assertions.assertEquals(resultadoEsperado, resultadoObtenido);

    }

    @Test
    public void CP0008_Reserva_vuelo_Sin_Seleccionar_Equipaje_NO_OK() throws InterruptedException {
        home.aceptarCookies();
        home.ingresarOrigen();
        home.ingresarDestino();
        home.seleccionarVueloSoloIda();
        home.ingresarFechaSalida();
        home.buscar();
        vuelosPage.seleccionarVuelo();
        vuelosPage.confirmarVuelo();
        vuelosPage.elegirTarifa("Elegir Classic");
        contacto.completarDatosContacto("Juan", "Perez", "elasdelaspruebasautomatizadas@yahoo.com.es", "2224545454", "mi calle", 1234, "70000", "Barcelona", "10", "enero", "2000");
        contacto.confirma();
        contacto.detectaFaltaSelecionEquipaje();
        Boolean resultadoEsperado = true;
        Boolean resultadoObtenido = contacto.detectaFaltaSelecionEquipaje();
        Assertions.assertEquals(resultadoEsperado, resultadoObtenido);
    }

   @Test
    public void CP009_Reserva_Otro_Idioma_OK() throws InterruptedException {
        home.aceptarCookies();
        home.seleccionarPais();
        home.aceptarCookiesIngles();
        home.selectOneWay();
        Boolean resultadoEsperado = true;
        Boolean resultadoObtenido = contacto.detectaFaltaSelecionEquipaje();
        Assertions.assertEquals(resultadoEsperado, resultadoObtenido);

    }

    @Test
    public void CP001_Busqueda_hotel_OK() {
        home.aceptarCookies();
        hotelPage.maximizarBrowser();
        hotelPage.completarCamposBusquedaHoteles("Barcelona");

    }

    @Test
    public void CP002_Busqueda_Hotel_Fecha_no_Ok()  {

        home.aceptarCookies();
        hotelPage.maximizarBrowser();
        hotelPage.completarCamposBusquedaHoteles_fecha_deshabilitada("Barcelona");


    }


}





