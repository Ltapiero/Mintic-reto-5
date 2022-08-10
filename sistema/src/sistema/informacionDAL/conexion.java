
package sistema.informacionDAL;
import java.sql.*;

public class conexion {
    String strConexionDB = "jdbc:sqlite:C:/Users/Luis Tapiero/Downloads/Estudio WEB/Mintic Proyectos/Ciclo 2/Reto 5/ProyectosConstruccion.db";
    //String strConexionDB = "jdbc:sqlite:db/ProyectosConstruccion.db";
    Connection conn = null;

    public conexion() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(strConexionDB);
            System.out.println("Conexion establecida");
        } catch (Exception e) {
            System.out.println("Error de conexion: " + e);
        }
    }
    

    
    public ResultSet consultarRegistros(String strSentenciaSQL){
        try {
            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            ResultSet respuesta = pstm.executeQuery();
            return respuesta;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
