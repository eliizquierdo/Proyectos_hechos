package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * La clase GestionCuentas proporciona métodos para gestionar la información relacionada con las cuentas en la base de datos.
 * Incluye operaciones como la inserción de puntuaciones y comentarios asociados a perfiles de usuarios y programación visualizada.
 */

public class GestionCuentas {
	
	/**
     * Inserta una nueva puntuación y comentarios asociados a la visualización de un programa por parte de un usuario.
     *
     * @param id_Profile          El identificador del perfil de usuario que realiza la puntuación.
     * @param id_Programming     El identificador del programa visualizado.
     * @param viewingStartDate   La fecha de inicio de la visualización.
     * @param viewingEndDate     La fecha de fin de la visualización.
     * @param score              La puntuación asignada al programa.
     * @param comments           Comentarios adicionales proporcionados por el usuario.
     * @return                   true si la inserción fue exitosa, false en caso contrario.
     */
	
	public static boolean insertScore(String id_Profile, int id_Programming, LocalDate viewingStartDate, LocalDate viewingEndDate, int score, String comments) {
	    Connection connection = null;
	    try {
	        connection = ConnectionMySQL.getConnection();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    if (connection != null) {
	        try {
	            String sql = "INSERT INTO scored (id_Profile, id_Programming, viewingStartDate, viewingEndDate, score, comments) "
	                    + "VALUES (?, ?, ?, ?, ?, ?)";

	            PreparedStatement estScore = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

	            estScore.setString(1, id_Profile);
	            estScore.setInt(2, id_Programming);
	            estScore.setDate(3, java.sql.Date.valueOf(viewingStartDate));
	            estScore.setDate(4, java.sql.Date.valueOf(viewingEndDate));
	            estScore.setInt(5, score);
	            estScore.setString(6, comments);

	            estScore.executeUpdate();

	            // Obtener la clave generada, si es necesario
	            ResultSet generatedKeys = estScore.getGeneratedKeys();
	            if (generatedKeys.next()) {
	                int idScore = generatedKeys.getInt(1);
	                System.out.println("Se generó la clave primaria con el valor: " + idScore);
	                
	            }
	            return true;
	        } catch (SQLException e) {
	            System.err.println("Error al insertar datos en la tabla 'score': " + e.getMessage());
	        } finally {
	            try {
	                if (connection != null) {
	                    connection.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    return false;
	}


	
	
}
