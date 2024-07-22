package presencial;

public class Hotel {
    private String fechaEntrada;
    private String fechaSalida;
    private String ciudad;

    public Hotel(String fechaEntrada, String fechaSalida, String ciudad) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.ciudad = ciudad;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public String getCiudad() {
        return ciudad;
    }


}
