package presencial;

public class FacadeBusquedaa implements iFacade{
    private ApiHotel apiHotel;
    private ApiVuelo apiVuelo;

    public FacadeBusquedaa() {
        apiHotel = new ApiHotel();
        apiVuelo = new ApiVuelo();
    }

    @Override
    public String busquedaVueloHotel(Vuelo vuelo, Hotel hotel) {
        String resultado = "";
        resultado = resultado + apiHotel.busqueda(hotel) + "\n" + apiVuelo.busqueda(vuelo);
        return resultado;
    }
}
