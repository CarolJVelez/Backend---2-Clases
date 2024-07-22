import dao.BD;
import model.Medicamento;
import service.MedicamentoService;

import java.util.List;

public class Cliente {
    public static void main(String[] args) {
        //cual es el primer paso?
        BD.crearTablas();
        //Ahora creo el medicamento
        Medicamento medicamento1= new Medicamento(1,1234,"Ibuprofeno","Bago",10,100.0);
        Medicamento medicamento2= new Medicamento(2,2345,"Acetaminofen","Bago",20,120.0);
        Medicamento medicamento3= new Medicamento(3,3456,"Naproxeno","Bago",30,130.0);
        //quien debe guardar el medicamento?
        MedicamentoService medicamentoService= new MedicamentoService();
        ///ahora que tenemos el service?
        medicamentoService.guardarMedicamento(medicamento1);
        medicamentoService.guardarMedicamento(medicamento2);
        medicamentoService.guardarMedicamento(medicamento3);
        System.out.println("*********************************");


        //orden de sucesos

        /*
        * 1 service
        * 2 dao correspondiente
        *3 bd
        * 4 entity o model
        *  */

        Medicamento medicamentoBuscar = medicamentoService.buscarMedicamentoPorId(2);
        System.out.println(medicamentoBuscar.toString());
        System.out.println("*********************************");

        Medicamento medicamentoActualizar = medicamentoService.actualizarPrecioPorId(2, 190.0);
        System.out.println(medicamentoActualizar.toString());

        List<Medicamento> medicamentosRestantes = medicamentoService.eliminarMedicamentoPorId(1);
        for (Medicamento medicamento : medicamentosRestantes) {
            System.out.println(medicamento.toString());
        }
        System.out.println("*********************************");
    }
}
