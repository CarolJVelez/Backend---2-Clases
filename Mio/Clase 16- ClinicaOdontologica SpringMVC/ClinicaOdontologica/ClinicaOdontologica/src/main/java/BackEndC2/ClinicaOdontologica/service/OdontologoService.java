package BackEndC2.ClinicaOdontologica.service;

import BackEndC2.ClinicaOdontologica.dao.OdontologoDAOH2;
import BackEndC2.ClinicaOdontologica.dao.iDao;
import BackEndC2.ClinicaOdontologica.model.Odontologo;
import BackEndC2.ClinicaOdontologica.model.Paciente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService {

    private iDao<Odontologo> odontologoiDao;

    public OdontologoService() {
        odontologoiDao =  new OdontologoDAOH2();
    }


    public Odontologo guardarOdontologo(Odontologo odontologo){
        return odontologoiDao.guardar(odontologo);
    }

    public Odontologo buscarOdontologo(Integer id){
        return odontologoiDao.buscarPorID(id);
    }

    public List<Odontologo> buscarTodos(){
        return odontologoiDao.buscarTodos();
    }

    public void actualizarOdontologo(Odontologo odontologo){
        odontologoiDao.actualizar(odontologo);
    }

    public void eliminarOdontologo(Integer id){
        odontologoiDao.eliminar(id);
    }

}
