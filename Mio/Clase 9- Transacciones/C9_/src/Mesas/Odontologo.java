package Mesas;


import java.sql.*;

public class Odontologo {
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/odontologo";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";

    private final static String CREATE_TABLE = "DROP TABLE IF EXISTS odontologo; CREATE TABLE odontologo(id int not null primary key" +
            ", apellido varchar(100) not null" +
            ", nombre varchar(100) not null" +
            ", matricula varchar(100) not null" +
            ");";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();

            // CREAR TABLA
            Statement stmt = connection.createStatement();
            stmt.execute(CREATE_TABLE);


            String nombre = "Ramiro";
            String apellido = "Gonzalez";
            String matricula = "DOC-1515";

            // 2. Crear una sentencia:
            preparedStatement = connection.prepareStatement("INSERT INTO odontologo(id, apellido, nombre, matricula) VALUES(?,?,?,?)");
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, apellido);
            preparedStatement.setString(3, nombre);
            preparedStatement.setString(4, matricula);

            // 3. Ejecutar la sentencia
            preparedStatement.execute(); // INSERT
            System.out.println("Se inserto registro");

            preparedStatement = connection.prepareStatement("SELECT * FROM odontologo WHERE id = ?");
            preparedStatement.setInt(1, 1);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("nombre")
                        + " - " + rs.getString("apellido")
                        + " - " + rs.getString("matricula"));
            }


            matricula = "DOC-1616";
            // 4. Ejecutar update
            preparedStatement = connection.prepareStatement("UPDATE odontologo SET matricula = ? WHERE id = ?");
            preparedStatement.setString(1, matricula);
            preparedStatement.setInt(2, 1);
            preparedStatement.execute();
            System.out.println("Se actualizo registro");

            preparedStatement = connection.prepareStatement("SELECT * FROM odontologo WHERE id = ?");
            preparedStatement.setInt(1, 1);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("nombre")
                        + " - " + rs.getString("apellido")
                        + " - " + rs.getString("matricula"));
            }

            preparedStatement.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception{
        Class.forName(DB_JDBC_DRIVER);
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
