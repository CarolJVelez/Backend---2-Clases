package BackEndC2.ClinicaOdontologica.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Turno {

    private Integer id;
    private Odontologo odontologo;
    private Paciente paciente;
    private LocalDate fechaCita;
}
