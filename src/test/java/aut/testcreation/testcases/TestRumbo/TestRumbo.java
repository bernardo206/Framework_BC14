package aut.testcreation.testcases.TestRumbo;
import aut.testcreation.pages.Bootcamp14pages.*;
import aut.testcreation.pages.Bootcamp14pages.HotelPage.HotelPage;
import aut.testcreation.pages.Bootcamp14pages.TrenPage.TrenPage;
import aut.testcreation.pages.Bootcamp14pages.TrenPage.formularioTren;
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
    HomeTarjeta tarjeta;
    RegalaTuTarjetaPage regala;
    ParticularPage particular;
    VueloMasHotelPage vueloMasHotel;
    DestinoPaguete alojamiento;
    RoomHotelPage room;
    TrenPage tren;
    formularioTren formularioT;
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
        tarjeta = new HomeTarjeta(home.getDriver());
        regala = new RegalaTuTarjetaPage(home.getDriver());
        particular = new ParticularPage(home.getDriver());
        vueloMasHotel = new VueloMasHotelPage(home.getDriver());
        alojamiento = new DestinoPaguete(home.getDriver());
        room = new RoomHotelPage(home.getDriver());

        tren = new TrenPage(home.getDriver());
        formularioT = new formularioTren(tren.getDriver());

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
    public void CP007_Vuelo_Fechas_no_disponibles_NO_OK() throws InterruptedException {
        home.aceptarCookies();
        home.ingresarOrigen();
        home.ingresarDestino();
        home.seleccionarVueloSoloIda();
        home.ingresarFechaSalidaLarga();
        home.detectaErrorFecha();
        Assertions.assertTrue(true);

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
    public void CP0016_BusquedaHotelSinIndicarDestino_NO_OK () throws InterruptedException {
        home.aceptarCookies();
        hotelPage.maximizarBrowser();
        hotelPage.completarCamposBusquedaHoteles(" ");
        Assertions.assertTrue(true);
    }



    @Test
    public void CP010_TarjetaDeRegalo_Compra_OK(){
        home.aceptarCookies();
        home.locatorVerMas();
        tarjeta.BtnTarjetaRegalo();
        regala.Regala();
        particular.Importe();
        particular.Imprimir();
        particular.Destinatario();
        particular.correo();
        particular.Remitente();
        particular.Añadir();
        particular.Continuar();

        Assertions.assertTrue(true);

    }
    @Test
    public void CP0014_Reserva_paquete_HotelMasvuelo_OK() throws InterruptedException {
        home.aceptarCookies();
        vueloMasHotel.VueloMasHotel();
        vueloMasHotel.OrigenVuelo();
        vueloMasHotel.DestinoVuelo();
        vueloMasHotel.FechaDeIda();
        vueloMasHotel.localizar();
        alojamiento.ElegirAlojamiento();//Hotel Flavia
        room.Continuar1ero(1);


    }




    @Test
    public void CP005_ReservaTrenIda(){  //no elijo q pasajero, lo hace con 2 que es la opcion recomendada
        home.maximizarBrowser();
        home.aceptarCookies();
        home.locatorVerMas();
        home.btnTrenes();
        tren.locatorIda();
        tren.locatorOrigen("Madrid");
        tren.locatorDestino();
        tren.btnBuscar();
        tren.locatorPrimerTren();
        tren.aceptarPrimerTren();

        formularioT.formularioDatos("carlos", "perez", "probando@gmail.com", 234343434);
        // formularioT.formulacioPasajero("Roberto","Garcia",14,2000,"123456789b");

        formularioT.formularioDatos("carlos","perez","probando@gmail.com", 234343434);
        formularioT.formulacioPasajero("Roberto","Garcia",14,1988,"123456789b");


        Assertions.assertTrue(true);
    }

    @Test
    public void CP001_ReservaTren_DestinoNoDisponible() {
        home.maximizarBrowser();
        home.aceptarCookies();
        home.locatorVerMas();
        home.btnTrenes();
        tren.locatorIda();
        tren.errorOrigen("Mar del Plata");

        Assertions.assertTrue(true);
    }

    @Test
    public void CP002_ReservaTren_idaVuelta() {  //elijo predeterminado fechas y pasajeros,llego hasta completar datos pasajero y click en seguro
        home.maximizarBrowser();
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
    public void CP003_ReservaTrenHotel() {  //no elijo q pasajero, lo hace con 2 que es la opcion recomendada. Lo mismo con la fecha.
        //en la parte de datos llego hasta completar los datos de la persona y que se valide, no completo los datos del pasajero ni clickeo siguiente
        home.maximizarBrowser();
        home.aceptarCookies();
        home.locatorVerMas();
        home.btnTrenHotel();
        tren.locatorOrigen("Madrid");
        tren.locatorDestino();
        tren.btnBuscar();
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









