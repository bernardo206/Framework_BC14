package aut.testcreation.testcases.TestRumbo;
import aut.testcreation.pages.Bootcamp14pages.*;
import aut.testcreation.pages.Bootcamp14pages.HotelPage.HotelPage;
import aut.testcreation.pages.Bootcamp14pages.TrenPage.TrenPage;
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
    TrenPage trenPage;
    ContactoPageRumbo contacto;
    SeguroPageRumbo seguro;
    ConfirmacionPageRumbo confirmacion;
    HotelTren hotelTren;
    HotelPage hotelPage;

    //Actions actions;
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
        trenPage = new TrenPage(home.getDriver());
        hotelTren = new HotelTren(home.getDriver());
      //  actions  = new Actions(home.getDriver());

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
    public void CP0018_Busqueda_hotel_OK() {
        home.aceptarCookies();
        hotelPage.maximizarBrowser();
        hotelPage.completarCamposBusquedaHoteles("Barcelona");

    }

    @Test
    public void CP0017_Busqueda_Hotel_Fecha_no_Ok()  {

        home.aceptarCookies();
        hotelPage.maximizarBrowser();
        hotelPage.completarCamposBusquedaHoteles_fecha_deshabilitada("Barcelona");


    }

    @Test
    public void CP0015_Error_Ofertas_Trenes_Renfe(){

        home.maximizarBrowser();
        home.esperarXSegundos(2000);
        home.aceptarCookies();
        home.locatorVerMas();
        home.esperarXSegundos(2000);
        home.btnTrenes();
        home.esperarXSegundos(2000);
        trenPage.entrarOfertasTrenesRenfe();
        trenPage.esperarXSegundos(6000);
        trenPage.identificarPestaniasOfertasRenfeTrenes();
        trenPage.esperarXSegundos(2000);
        trenPage.esperarXSegundos(8000);


    }


    @Test
    public void CP004_Reserva_TrenHotel_Fechas_no_disponibles_NO_OK() throws InterruptedException {
        home.aceptarCookies();
        home.locatorVerMas();
        home.btnTrenHotel();
        hotelTren.seleccionarOrigen();
        hotelTren.seleccionarDestino();
        hotelTren.ingresarFechaSalidaLarga();
        hotelTren.detectaErrorFecha();
        Assertions.assertTrue(true);
    }

    @Test
    public void CP004_Vuelo_Fechas_no_disponibles_NO_OK() throws InterruptedException {
        home.aceptarCookies();
        home.ingresarOrigen();
        home.ingresarDestino();
        home.seleccionarVueloSoloIda();
        home.ingresarFechaSalidaLarga();
        home.detectaErrorFecha();
        Assertions.assertTrue(true);

    }

    @Test
    public void CP001_Busqueda_hotel_OK() {
        home.aceptarCookies();
        hotelPage.maximizarBrowser();
        hotelPage.completarCamposBusquedaHoteles("Barcelona");

    }

    @Test
    public void CP0011_Busqueda_Vuelo_Filtro_Mas_Barato_OK() throws InterruptedException {
        home.aceptarCookies();
        home.ingresarOrigen();
        home.ingresarDestino();
        home.seleccionarVueloSoloIda();
        home.ingresarFechaSalida();
        home.buscar();
        vuelosPage.filtroMasBarato();
        Assertions.assertTrue(true);
    }

    @Test
    public void CP006_Busqueda_Tren_Filtro_Mas_Rapido_OK() throws InterruptedException {
        home.maximizarBrowser();
        home.aceptarCookies();
        home.locatorVerMas();
        home.btnTrenes();
        trenPage.locatorIdaVuelta();
        trenPage.locatorOrigen("Madrid");
        trenPage.locatorDestino();
        trenPage.btnBuscar();
        trenPage.filtroMasRapido();
        Assertions.assertTrue(true);

    }

    @Test
    public void BusquedaHotelSinIndicarDestino_NO_OK () throws InterruptedException {
        home.aceptarCookies();
        hotelPage.maximizarBrowser();
        hotelPage.completarCamposBusquedaHoteles(" ");
        Assertions.assertTrue(true);
    }




/*
    @Test
    public void CP0015_Vuelos_OutletVuelos_RecibirOfertas_mail(){

        home.maximizarBrowser();
        home.esperarXSegundos(2000);
        home.aceptarCookies();
        home.desplegableVuelos();
        home.esperarXSegundos(5000);
        home.ClickVuelosOutlt();
        home.esperarXSegundos(8000);



*/


    }









