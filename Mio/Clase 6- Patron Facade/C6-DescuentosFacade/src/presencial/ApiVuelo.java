package presencial;

public class ApiVuelo {
    public String busqueda(Vuelo vuelo){
        String listaDeVuelos = "";
        if (vuelo.getFechaSalida().equals("1") && vuelo.getDestino().equals("Tokio")){
            listaDeVuelos  = listaDeVuelos + "vuelo 1";
        } else if (vuelo.getFechaSalida().equals("2") && vuelo.getDestino().equals("París")) {
            listaDeVuelos = listaDeVuelos + "vuelo 2";
        }
        System.out.println("Lista de vuelos: " + listaDeVuelos);
        return listaDeVuelos;
    }
}
