package logica;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import persistencia.ConnectionMySQL;

/**
 * La clase `AccountsDAO` proporciona métodos para interactuar con la base de datos relacionados con las cuentas.
 */

public class AccountsDAO {
	
	/**
     * Inserta una nueva cuenta en la base de datos.
     *
     * @param account       La cuenta que se va a insertar.
     * @param id_Persons    El ID de la persona asociada a la cuenta.
     * @return              `true` si la inserción fue exitosa, `false` de lo contrario.
     */
	
	public static boolean insertAccount(AccountsVO account, int id_Persons) {
	    int numFAfectas = 0;

	    try {
	        Connection acceDB = ConnectionMySQL.getConnection();
	        String sqlAccount = "INSERT INTO ACCOUNTS (emailAccount, passwordAccount, cardName, cardNumber, cardCode, level, numberScreens, suscriptionDate, id_Persons) "
	                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

	        PreparedStatement statementAccount = acceDB.prepareStatement(sqlAccount, Statement.RETURN_GENERATED_KEYS);

	        statementAccount.setString(1, account.getEmailAccount());
	        statementAccount.setString(2, account.getPasswordAccount());
	        statementAccount.setString(3, account.getCardName());
	        statementAccount.setString(4, account.getCardNumber());
	        statementAccount.setString(5, account.getCardCode());
	        statementAccount.setString(6, account.getLevel());
	        statementAccount.setString(7, account.getNumberScreens());
	        statementAccount.setDate(8, (Date) account.getSuscriptionDate());
	        statementAccount.setInt(9, id_Persons);

	        numFAfectas = statementAccount.executeUpdate();

	        if (numFAfectas > 0) {
	        	return true;
	        } else {
	            // Manejar el caso en que la inserción en ACCOUNTS falla
	            return false;
	        }
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	        return false;
	    }
	}
	
	/**
     * Elimina una cuenta de la base de datos dado su correo electrónico y contraseña.
     *
     * @param emailAccount      El correo electrónico de la cuenta.
     * @param passwordAccount   La contraseña de la cuenta.
     * @return                  Un mensaje indicando el resultado de la operación.
     */

	public static String deleteAccount(String emailAccount, String passwordAccount) {

		String rptaDelete = null;
		int numFAfectasAcc = 0;
		

		try {
			Connection accesoDB = ConnectionMySQL.getConnection();

			String sqlAccount = "DELETE FROM ACCOUNTS WHERE emailAccount =? AND passwordAccount = ?;";
			

			PreparedStatement statementAcc = accesoDB.prepareStatement(sqlAccount);
			
			statementAcc.setString(1, emailAccount);
			statementAcc.setString(2, passwordAccount);
			

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
	
	/**
     * Verifica las credenciales de una cuenta en la base de datos.
     *
     * @param email     El correo electrónico de la cuenta.
     * @param password  La contraseña de la cuenta.
     * @return          El ID de la persona asociada a la cuenta si las credenciales son válidas, 0 de lo contrario.
     */
	
	public static int verifyAccount(String email, String password) {
	    Connection connection = null;
	    int id_Persons = 0;
	    
	    try {
	        connection = ConnectionMySQL.getConnection();

	        // Consulta SQL para verificar las credenciales
	        String consulta = "SELECT id_Persons FROM ACCOUNTS WHERE emailAccount = ? AND passwordAccount = ?";
	        PreparedStatement statement = connection.prepareStatement(consulta);
	        statement.setString(1, email);
	        statement.setString(2, password);
	        
	        ResultSet resultado = statement.executeQuery();
	       
	        if (resultado.next()) {
	            // Las credenciales son válidas, devuelve el valor de id_Persons
	            id_Persons = resultado.getInt("id_Persons");
	            return id_Persons;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 

	    // Las credenciales son incorrectas
	    System.out.println(id_Persons);
	    return id_Persons;
	}
	
	

}
