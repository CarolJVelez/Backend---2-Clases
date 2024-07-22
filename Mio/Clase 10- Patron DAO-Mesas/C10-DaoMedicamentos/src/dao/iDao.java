package dao;

import java.util.List;

public interface iDao<T> {
    //todos los metodos comunes para desp implementar en los dao
    //aca debemos tener el CRUD
     T guardar(T t);

     T buscarPorID(Integer id);

     T actualizarPrecioPorID(Integer id, Double precio);
     List<T> eliminarPorId(Integer id);


}
