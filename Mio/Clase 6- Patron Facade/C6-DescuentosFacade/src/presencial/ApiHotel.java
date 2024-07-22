package presencial;

public class ApiHotel {
    public String busqueda(Hotel hotel){
        String listaDeHoteles = "";
        if (hotel.getFechaEntrada().equals("1") && hotel.getCiudad().equals("Tokio")){
            listaDeHoteles  = listaDeHoteles + "hotel 1";
        } else if (hotel.getFechaEntrada().equals("2") && hotel.getCiudad().equals("París")) {
            listaDeHoteles  = listaDeHoteles + "hotel 2";
        }
        System.out.println("Lista hoteles: " + listaDeHoteles);
        return listaDeHoteles;
    }
}
