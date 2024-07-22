package BackEndC2.ClinicaOdontologica.service;

import BackEndC2.ClinicaOdontologica.model.Paciente;
import BackEndC2.ClinicaOdontologica.dao.PacienteDAOH2;
import BackEndC2.ClinicaOdontologica.dao.iDao;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PacienteService {
    //relacion de asociacion directa con el DAO
    private iDao<Paciente> pacienteiDao;

    public PacienteService() {
        pacienteiDao= new PacienteDAOH2();
    }
    public Paciente guardarPaciente(Paciente paciente){
        return pacienteiDao.guardar(paciente);
    }
    public Paciente buscarPaciente(Integer id){
        return pacienteiDao.buscarPorID(id);
    }
    public List<Paciente> buscarTodos(){
        return pacienteiDao.buscarTodos();
    }
    public void actualizarPaciente(Paciente paciente){
        pacienteiDao.actualizar(paciente);
    }
    public Paciente buscarPorCorreo(String correo){
        return pacienteiDao.buscarPorString(correo);
    }
    public void eliminarPaciente(Integer id){
        pacienteiDao.eliminar(id);
    }

}
