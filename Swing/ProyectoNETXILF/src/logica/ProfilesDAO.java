package logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import persistencia.ConnectionMySQL;

/**
 * La clase `ProfilesDAO` proporciona métodos para interactuar con la tabla PROFILES en la base de datos, como la inserción, recuperación y eliminación de perfiles.
 */
public class ProfilesDAO {

    /**
     * Inserta un nuevo perfil en la base de datos.
     *
     * @param profile       El perfil a insertar.
     * @param emailAccount  El correo electrónico asociado al perfil.
     * @return              Un mensaje indicando el resultado de la operación.
     */
    public static String insertProfiles(ProfilesVO profile, String emailAccount) {
        String rptaRegistro = null;
        int numFAfectasProfile = 0;

        try {
            Connection acceDB = ConnectionMySQL.getConnection();
            String sqlProfiles = "INSERT INTO PROFILES (nameProfile, PIN, emailAccount) " + "VALUES (?, ?, ?)";

            PreparedStatement statementProfiles = acceDB.prepareStatement(sqlProfiles, Statement.RETURN_GENERATED_KEYS);

            statementProfiles.setString(1, profile.getNameProfile());
            statementProfiles.setString(2, profile.getPIN());
            statementProfiles.setString(3, emailAccount);

            numFAfectasProfile = statementProfiles.executeUpdate();

            if (numFAfectasProfile > 0) {
                rptaRegistro = "Registro exitoso.";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rptaRegistro;
    }

    /**
     * Recupera los nombres de los perfiles asociados a un correo electrónico.
     *
     * @param mail  El correo electrónico asociado a los perfiles.
     * @return      Un array de String con los nombres de los perfiles.
     */
    public static String[] returnNames(String mail) {

        Connection connection = null;
        String[] nombres = null;
        ArrayList<String> nombresList = new ArrayList<>();

        try {
            connection = ConnectionMySQL.getConnection();

            // Consulta SQL para verificar nombres mediante mail
            String query = "SELECT nameProfile FROM PROFILES WHERE emailAccount = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, mail);

            ResultSet resultado = statement.executeQuery();

            while (resultado.next()) {
                // Agrega cada nombre a la lista
                nombresList.add(resultado.getString("nameProfile"));
            }

            // Convierte la lista a un array de String
            nombres = nombresList.toArray(new String[0]);

            return nombres;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Asegúrate de cerrar la conexión en el bloque finally
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        // En caso de error o si no hay nombres encontrados
        return new String[0]; // Puedes devolver un array vacío o manejarlo según tus necesidades
    }

    /**
     * Recupera los IDs de los perfiles asociados a un correo electrónico.
     *
     * @param mail  El correo electrónico asociado a los perfiles.
     * @return      Un array de String con los IDs de los perfiles.
     */
    public static String[] returnIdProfile(String mail) {

        Connection connection = null;
        String[] nombres = null;
        ArrayList<String> nombresList = new ArrayList<>();

        try {
            connection = ConnectionMySQL.getConnection();

            // Consulta SQL para verificar IDs mediante mail
            String query = "SELECT id_Profile FROM PROFILES WHERE emailAccount = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, mail);

            ResultSet resultado = statement.executeQuery();

            while (resultado.next()) {
                // Agrega cada ID a la lista
                nombresList.add(resultado.getString("id_Profile"));
            }

            // Convierte la lista a un array de String
            nombres = nombresList.toArray(new String[0]);

            return nombres;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Asegúrate de cerrar la conexión en el bloque finally
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        // En caso de error o si no hay IDs encontrados
        return new String[0]; // Puedes devolver un array vacío o manejarlo según tus necesidades
    }

    /**
     * Elimina un perfil de la base de datos.
     *
     * @param nameProfile   El nombre del perfil a eliminar.
     * @param PIN           El PIN asociado al perfil.
     * @param emailAccount  El correo electrónico asociado al perfil.
     * @return              Un mensaje indicando el resultado de la operación.
     */
    public static String deleteProfile(String nameProfile, String PIN, String emailAccount) {

        String rptaDelete = null;
        int numFAfectasAcc = 0;

        try {
            Connection accesoDB = ConnectionMySQL.getConnection();

            String sqlAccount = "DELETE FROM PROFILES WHERE nameProfile =? AND PIN = ? AND emailAccount = ?;";

            PreparedStatement statementAcc = accesoDB.prepareStatement(sqlAccount);

            statementAcc.setString(1, nameProfile);
            statementAcc.setString(2, PIN);
            statementAcc.setString(3, emailAccount);

            numFAfectasAcc = statementAcc.executeUpdate();

            System.out.println(numFAfectasAcc);

            if (numFAfectasAcc > 0) {
                rptaDelete = "Registro exitoso.";
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rptaDelete;
    }
    
    public static int verifyProfile(String nombre, String PIN, String account) {
	    Connection connection = null;
	    int id_Profile = 0;
	    
	    try {
	        connection = ConnectionMySQL.getConnection();

	        // Consulta SQL para verificar las credenciales
	        String consulta = "SELECT id_Profile FROM PROFILES WHERE emailAccount = ? AND nameProfile = ? AND PIN = ?";
	        PreparedStatement statement = connection.prepareStatement(consulta);
	        statement.setString(1, account);
	        statement.setString(2, nombre);
	        statement.setString(3, PIN);
	        
	        ResultSet resultado = statement.executeQuery();
	        
	        if (resultado.next()) {
	            // Las credenciales son válidas, devuelve el valor de id_Persons
	            id_Profile = resultado.getInt("id_Profile");
	            
	        }
	        return id_Profile;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 

	    // Las credenciales son incorrectas
	    
	    return id_Profile;
	}

}
