package presencial;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.parallel.Execution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Cliente {

    //UTIIZANDO EL LOG4
    private static final Logger logger = Logger.getLogger(Cliente.class);
    public static void main(String[] args) {

        //crear una conexion
        Connection connection =null;
        try{
            connection = getConnection();//traigo la conexcion
            Statement statement = connection.createStatement();//encargado de llevar el mundo de los objetos a las tablas
            statement.execute("DROP TABLE IF EXISTS ANIMALES; CREATE TABLE ANIMALES"+
                    "(ID INT PRIMARY KEY, NOMBRE VARCHAR(100) NOT NULL, TIPO VARCHAR(100) NOT NULL)");//CREAR TABLA
            //INSERAT ANIMALES
            statement.execute("INSERT INTO ANIMALES VALUES(1, 'PEDRO', 'PERRO'), (2, 'CHISPAS', 'CONEJO'), (3, 'LAILA', 'GATO')");
            logger.info("Se insertaron los registros");

            //MOSTRAR 3 ANIMALES
            ResultSet rs = statement.executeQuery("SELECT * FROM ANIMALES");
            //NECESITO SI O SI RECORRER PARA VER LOS DATOS
            while(rs.next()){
                System.out.println("Nombre "+rs.getString(2)+ " Tipo: "+rs.getString(3));
            }
            System.out.println("********************************");

            //Como eliminar un registro
            statement.execute("DELETE FROM ANIMALES WHERE ID = 1");
            logger.warn("Se elimino un registro");

            //MOSTRAR 2 ANIMALES
            ResultSet rs1 = statement.executeQuery("SELECT * FROM ANIMALES");
            //NECESITO SI O SI RECORRER PARA VER LOS DATOS
            while(rs1.next()){
                System.out.println("Nombre "+rs1.getString(2)+ " Tipo: "+rs1.getString(3));
            }
            System.out.println("********************************");
            //Como ACTUALIZAR un registro
           // statement.execute("UPDATE ANIMALES SET NOMBRE = 'CAROL' WHERE ID = 2");


        }catch (Exception e){
             e.printStackTrace();
        }
    }

    //conexion de la base de datos
    public static Connection getConnection() throws Exception {
        //ahora debo de cargar el driver
        Class.forName("org.h2.Driver");

        //return DriverManager.getConnection("jdbc:h2:~/mem","sa","sa");//el mem significa que se activida y surve si ssolo esta corriendo
        //api jdbc, nombre de la base de datos, el software que gesiona, el nombre de la base...
        return DriverManager.getConnection("jdbc:h2:~/c8Animales","sa","sa");
    }
}
