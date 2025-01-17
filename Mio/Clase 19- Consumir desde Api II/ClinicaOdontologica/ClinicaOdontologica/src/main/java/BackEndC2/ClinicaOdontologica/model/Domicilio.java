package BackEndC2.ClinicaOdontologica.model;

import lombok.Data;

@Data
public class Domicilio {
    private Integer id;
    private String calle;
    private Integer numero;
    private String localidad;
    private String provincia;

    public Domicilio(Integer id, String calle, Integer numero, String localidad, String provincia) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public Domicilio() {
    }

    public Domicilio(String calle, Integer numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

}
