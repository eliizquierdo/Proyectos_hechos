package logica;

import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import persistencia.ConnectionMySQL;

public class PersonsDAO {

	

	

	public static int insertPerson(PersonsVO person) {
		int id_Persons = -1;
		int numFAfectas = 0;
		int numFAfectasPho = 0;

		if (person.getTypePerson().equals("Client")) {
			try {
				Connection acceDB = ConnectionMySQL.getConnection();
				String sqlPersons = "INSERT INTO PERSONS (typePersons, namePersons, lastName, city, country) "
						+ "VALUES (?, ?, ?, ?, ?)";
				String sqlPhones = "INSERT INTO PHO_PER (id_Persons, phones) " + "VALUES (?, ?)";

				PreparedStatement statementPersons = acceDB.prepareStatement(sqlPersons,
						Statement.RETURN_GENERATED_KEYS);
				PreparedStatement statementPhones = acceDB.prepareStatement(sqlPhones);

				statementPersons.setString(1, person.getTypePerson());
				statementPersons.setString(2, person.getNamePerson());
				statementPersons.setString(3, person.getLastName());
				statementPersons.setString(4, person.getCity());
				statementPersons.setString(5, person.getCountry());

				numFAfectas = statementPersons.executeUpdate();

				ResultSet generatedKeys = statementPersons.getGeneratedKeys();
				id_Persons = -1; // Inicializa un valor predeterminado en caso de que no se encuentre ningún
										// valor
				if (generatedKeys.next()) {
					id_Persons = generatedKeys.getInt(1); // Obtén el valor generado
				}

				statementPhones.setString(1, String.valueOf(id_Persons));
				statementPhones.setString(2, person.getPhones()[0]);

				numFAfectasPho = statementPhones.executeUpdate();

				if (person.getPhones().length == 2) {

					statementPhones.setString(1, String.valueOf(id_Persons));
					statementPhones.setString(2, person.getPhones()[1]);

					numFAfectasPho = statementPhones.executeUpdate();
				}

				if (numFAfectas > 0 && numFAfectasPho > 0) {
					return id_Persons;
				}else {
					return id_Persons;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return id_Persons;
			}
			
		} else {
			try {
				Connection acceDB = ConnectionMySQL.getConnection();
				String sqlPersons = "INSERT INTO PERSONS (typePersons, namePersons, lastName, city, country, emailAdmin, passwordAdmin) "
						+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
				String sqlPhones = "INSERT INTO PHO_PER (id_Persons, phones) " + "VALUES (?, ?)";

				PreparedStatement statementPersons = acceDB.prepareStatement(sqlPersons,
						Statement.RETURN_GENERATED_KEYS);
				PreparedStatement statementPhones = acceDB.prepareStatement(sqlPhones);

				statementPersons.setString(1, person.getTypePerson());
				statementPersons.setString(2, person.getNamePerson());
				statementPersons.setString(3, person.getLastName());
				statementPersons.setString(4, person.getCity());
				statementPersons.setString(5, person.getCountry());
				statementPersons.setString(6, person.getEmailAdmin());
				statementPersons.setString(7, person.getPasswordAdmin());
				

				numFAfectas = statementPersons.executeUpdate();

				ResultSet generatedKeys = statementPersons.getGeneratedKeys();
				id_Persons = -1; // Inicializa un valor predeterminado en caso de que no se encuentre ningún
										// valor
				if (generatedKeys.next()) {
					id_Persons = generatedKeys.getInt(1); // Obtén el valor generado
				}

				statementPhones.setString(1, String.valueOf(id_Persons));
				statementPhones.setString(2, person.getPhones()[0]);

				numFAfectasPho = statementPhones.executeUpdate();

				if (person.getPhones().length == 2) {

					statementPhones.setString(1, String.valueOf(id_Persons));
					statementPhones.setString(2, person.getPhones()[1]);

					numFAfectasPho = statementPhones.executeUpdate();
				}

				if (numFAfectas > 0 && numFAfectasPho > 0) {
					return id_Persons;
				}else {
					return id_Persons;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return id_Persons;
			}
			
		}
	}
	
	public static ListPersons listPersons() {
		ListPersons list = new ListPersons();
		
		Connection connection = null;

		try {
			connection = ConnectionMySQL.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (connection != null) {
			try {
				String sqlList = "SELECT PERSONS.*, PHO_PER.* FROM PERSONS LEFT JOIN PHO_PER ON PERSONS.id_Persons = PHO_PER.id_Persons;";
				
				
				PreparedStatement statement = connection.prepareStatement(sqlList);
				

				ResultSet resultSet = statement.executeQuery();
				

				while (resultSet.next()) {
					
					String id_Persons = resultSet.getString("id_Persons");
					
					String typePersons = resultSet.getString("typePersons");
					String namePersons = resultSet.getString("namePersons");
					String lastName = resultSet.getString("lastName");
					String city = resultSet.getString("city");
					String country = resultSet.getString("country");
					
					String emailAdmin = resultSet.getString("emailAdmin");
					String passwordAdmin = resultSet.getString("passwordAdmin");
					
					
					
					String phonesData = resultSet.getString("phones");
					String[] phones = phonesData.split(",");
					
					
					
					
					PersonsVO person = new PersonsVO(id_Persons, typePersons, namePersons, lastName, city, country, phones, emailAdmin, passwordAdmin);
	                list.add(person);
					
				}
				
				

			} catch (SQLException e) {
				System.err.println("Error al insertar datos en la tabla 'Clientes': " + e.getMessage());
			}
			return list;
		}
		return list;
	}
	
	public static void DeleteAdmin (String emailAdmin) {
		
		
        Connection connection = ConnectionMySQL.getConnection();

        // Primero, obtenemos el id_Persona del administrador
        String queryId_Persons = "SELECT id_Persons FROM PERSONS WHERE emailAdmin = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queryId_Persons);
            
            preparedStatement.setString(1, emailAdmin);

            int id_Persons = -1; // Valor predeterminado en caso de no encontrar el administrador

            // Ejecutar la consulta
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                id_Persons = resultSet.getInt("id_Persons");
            }

            resultSet.close();
            preparedStatement.close();

            // Si encontramos el id_Persona, eliminamos los registros relacionados
            if (id_Persons != -1) {
                // Eliminar de TEL_PER
                String deletePhoPer = "DELETE FROM PHO_PER WHERE id_Persons = ?";
                PreparedStatement deletePho_Per = connection.prepareStatement(deletePhoPer);
                deletePho_Per.setInt(1, id_Persons);
                deletePho_Per.executeUpdate();
                deletePho_Per.close();

                

                // Eliminar de PERSONAS
                String deletePerson = "DELETE FROM PERSONS WHERE id_Persons = ?";
                PreparedStatement deletePersons = connection.prepareStatement(deletePerson);
                deletePersons.setInt(1, id_Persons);
                deletePersons.executeUpdate();
                deletePersons.close();
                
                JOptionPane.showMessageDialog(null, "Administrador eliminado correctamente.", "Exito", JOptionPane.INFORMATION_MESSAGE);
                
                
            }else {
            	JOptionPane.showMessageDialog(null, "Correo electrónico no válido", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
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
	
	public static int verifyAccountAdmin(String email, String password) {
	    Connection connection = null;
	    int id_Persons = 0;
	    
	    try {
	        connection = ConnectionMySQL.getConnection();

	        // Consulta SQL para verificar las credenciales
	        String consulta = "SELECT id_Persons FROM PERSONS WHERE emailAdmin = ? AND passwordAdmin = ?";
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
