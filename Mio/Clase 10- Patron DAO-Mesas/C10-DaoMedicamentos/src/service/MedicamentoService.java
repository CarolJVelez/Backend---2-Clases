package service;

import dao.MedicamentoDAOH2;
import dao.iDao;
import model.Medicamento;

import java.util.ArrayList;
import java.util.List;

public class MedicamentoService {
    //la clase que se comunicaba con el DAO pq trae todas las peticiones de afuera
    //esta clase debe tener una relacion directa con el dao
    private iDao<Medicamento> medicamentoiDao;

    public MedicamentoService() {
        medicamentoiDao= new MedicamentoDAOH2();
    }
   //ahora en este punto necesitamos tener los metodos manuales de comunicacion con el DAOH2
    public Medicamento guardarMedicamento(Medicamento medicamento){
        return medicamentoiDao.guardar(medicamento);
   }

    public Medicamento buscarMedicamentoPorId(Integer id){
        return medicamentoiDao.buscarPorID(id);
    }

    public Medicamento actualizarPrecioPorId(Integer id, Double precio){
        return medicamentoiDao.actualizarPrecioPorID(id,precio);
    }
    public List<Medicamento> eliminarMedicamentoPorId(Integer id){
        return medicamentoiDao.eliminarPorId(id);
    }

}
