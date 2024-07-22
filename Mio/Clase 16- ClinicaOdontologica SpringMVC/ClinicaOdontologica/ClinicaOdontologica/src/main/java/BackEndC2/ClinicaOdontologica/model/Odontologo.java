package BackEndC2.ClinicaOdontologica.model;

import lombok.Data;

@Data
public class Odontologo {
    private Integer id;
    private Integer numeroMatricula;
    private String nombre;
    private String apellido;

    public Odontologo(Integer id, Integer numeroMatricula, String nombre, String apellido) {
        this.id = id;
        this.numeroMatricula = numeroMatricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Odontologo() {
    }
}
