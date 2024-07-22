package presencial;

public class Vuelo {
    private String fechaSalida;
    private String fechaRegreso;
    private String origen;
    private String destino;

    public Vuelo(String fechaSalida, String fechaRegreso, String origen, String destino) {
        this.fechaSalida = fechaSalida;
        this.fechaRegreso = fechaRegreso;
        this.origen = origen;
        this.destino = destino;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public String getFechaRegreso() {
        return fechaRegreso;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }


}
