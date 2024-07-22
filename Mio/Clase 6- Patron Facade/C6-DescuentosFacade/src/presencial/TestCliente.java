package presencial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCliente {
    public static void main(String[] args) {

        FacadeBusquedaa facadeBusquedaa = new FacadeBusquedaa();
        Hotel hotel = new Hotel("1", "1", "Tokio");
        Vuelo vuelo = new Vuelo("1", "1", "Tokio", "Tokio");

        String resultado = facadeBusquedaa.busquedaVueloHotel(vuelo, hotel);
        System.out.println(resultado);

    }
}
