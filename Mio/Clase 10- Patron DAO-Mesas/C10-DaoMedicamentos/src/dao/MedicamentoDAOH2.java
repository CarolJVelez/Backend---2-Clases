package dao;

import model.Medicamento;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MedicamentoDAOH2 implements iDao<Medicamento> {
    /*private Integer id;
  private Integer codigo;
  private String nombre;
  private String laboratorio;
  private Integer cantidad;
  private Double precio;*/
    private static final Logger logger= Logger.getLogger(MedicamentoDAOH2.class);
    private static final String SQL_INSERT="INSERT INTO MEDICAMENTOS VALUES(?,?,?,?,?,?)";
    private static final String SQL_SEARCH="SELECT * FROM MEDICAMENTOS WHERE ID=?";
    private static final String SQL_UPDATE="UPDATE MEDICAMENTOS SET precio=? WHERE ID=?";
    private static final String SQL_DELETE="DELETE FROM MEDICAMENTOS WHERE ID=?";

    private static final String SQL_SEARCH_ALL="SELECT * FROM MEDICAMENTOS";
    @Override
    public Medicamento guardar(Medicamento medicamento) {
        Connection connection= null;
        try{
            connection= BD.getConnection();
            logger.info("conexion establecida para guardar");
            PreparedStatement psInsert= connection.prepareStatement(SQL_INSERT);
            //ahora debemos cargar las parametrizadas
            psInsert.setInt(1,medicamento.getId());
            psInsert.setInt(2,medicamento.getCodigo());
            psInsert.setString(3, medicamento.getNombre());
            psInsert.setString(4, medicamento.getLaboratorio());
            psInsert.setInt(5,medicamento.getCantidad());
            psInsert.setDouble(6,medicamento.getPrecio());
            psInsert.execute();
            logger.warn("medicamento guardado con exito");
        }catch (Exception e){
            e.printStackTrace();
        }
        return medicamento;
    }

    @Override
    public Medicamento buscarPorID(Integer id) {
        Connection connection= null;
        Medicamento medicamento = new Medicamento();
        try{
            connection= BD.getConnection();
            logger.info("conexion establecida para listar");
            PreparedStatement psSearch= connection.prepareStatement(SQL_SEARCH);
            psSearch.setInt(1,id);
            ResultSet rs = psSearch.executeQuery();
            while (rs.next()){
                medicamento.setId(rs.getInt(1));
                medicamento.setCodigo(rs.getInt(2));
                medicamento.setNombre(rs.getString(3));
                medicamento.setLaboratorio(rs.getString(4));
                medicamento.setCantidad(rs.getInt(5));
                medicamento.setPrecio(rs.getDouble(6));
            }

            logger.warn("medicamento encontrado con exito");
        }catch (Exception e){
            e.printStackTrace();
        }
        return medicamento;
    }

    @Override
    public Medicamento actualizarPrecioPorID(Integer id, Double precio) {
        Connection connection = null;
        Medicamento medicamento = null;
        try {
            connection = BD.getConnection();
            logger.info("Conexión establecida para actualizar");

            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);
            psUpdate.setDouble(1, precio);
            psUpdate.setInt(2, id);

            int rowsUpdated = psUpdate.executeUpdate();
            if (rowsUpdated > 0) {
                logger.warn("Precio del medicamento actualizado con éxito");
                medicamento = buscarPorID(id);
            } else {
                logger.warn("No se encontró ningún medicamento para actualizar el precio");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return medicamento;
    }

    @Override
    public List<Medicamento> eliminarPorId(Integer id) {
        Connection connection = null;
        List<Medicamento> medicamentos = new ArrayList<>();
        try {
            connection = BD.getConnection();
            logger.info("Conexión establecida para eliminar");

            PreparedStatement psDelete = connection.prepareStatement(SQL_DELETE);
            psDelete.setInt(1, id);

            // Ejecutar la consulta de eliminación
            int rowsDeleted = psDelete.executeUpdate();

            if (rowsDeleted > 0) {
                logger.warn("Medicamento eliminado con éxito");

                PreparedStatement psSearch= connection.prepareStatement(SQL_SEARCH_ALL);
                ResultSet rs = psSearch.executeQuery();
                while (rs.next()){
                    // Creamos un nuevo objeto Medicamento en cada iteración
                    Medicamento medicamento = new Medicamento();
                    medicamento.setId(rs.getInt(1));
                    medicamento.setCodigo(rs.getInt(2));
                    medicamento.setNombre(rs.getString(3));
                    medicamento.setLaboratorio(rs.getString(4));
                    medicamento.setCantidad(rs.getInt(5));
                    medicamento.setPrecio(rs.getDouble(6));
                    medicamentos.add(medicamento);
                }
            } else {
                logger.warn("No se encontró ningún medicamento para eliminar con ID " + id);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return medicamentos;
    }
}


