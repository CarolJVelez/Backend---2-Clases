package BackEndC2.ClinicaOdontologica.controller;

import BackEndC2.ClinicaOdontologica.model.Odontologo;
import BackEndC2.ClinicaOdontologica.model.Paciente;
import BackEndC2.ClinicaOdontologica.service.OdontologoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologo")
public class OdontologoController {

    private OdontologoService odontologoService;

    public OdontologoController() {
       odontologoService = new OdontologoService();
    }

    @PostMapping //nos permite crear o registrar un paciente
    public Odontologo registrarodontologo(@RequestBody Odontologo odontologo){
        return odontologoService.guardarOdontologo(odontologo);
    }

    @GetMapping("/{id}")
    public Odontologo buscarPorId(@PathVariable Integer id){
        return odontologoService.buscarOdontologo(id);
    }

    @GetMapping
    public List<Odontologo> buscarTodos(){
        List<Odontologo> odontologos = odontologoService.buscarTodos();
        return odontologos;
    }

    @PutMapping
    public String actualizarOdontologo(@RequestBody Odontologo odontologo){
        //necesitamos primeramente validar si existe o  no
        Odontologo odontologoBuscado= odontologoService.buscarOdontologo(odontologo.getId());
        if(odontologoBuscado!=null){
            odontologoService.actualizarOdontologo(odontologo);
            return "Odontologo actualizado";
        }else{
            return "Odontologo no encontrado";
        }

    }

    @DeleteMapping("eliminar/{id}")
    public String eliminarOdontologo(Integer id){
        //necesitamos primeramente validar si existe o  no
        Odontologo OdontologoBuscado= odontologoService.buscarOdontologo(id);
        if(OdontologoBuscado!=null){
            odontologoService.eliminarOdontologo(id);
            return "Odontologo eliminado";
        }else{
            return "Odontologo no encontrado para eliminar";
        }

    }
}
