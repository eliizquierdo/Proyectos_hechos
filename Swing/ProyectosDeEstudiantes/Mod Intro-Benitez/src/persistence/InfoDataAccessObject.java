package persistence;

import logic.*;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class InfoDataAccessObject {
	private Connect conn;

	public InfoDataAccessObject(Connect connect) {
		this.conn = connect;
	}
    
	// Se establece un throws SQLException por si ocurre algún error al interactuar con la base de datos
	public List<Integer> getAllIDs() throws SQLException {
		List<Integer> ids = new ArrayList<>(); // Se inicializa una lista para almacenar los identificadores
		try (Connection connection = conn.getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT id FROM person");
				ResultSet resultSet = statement.executeQuery()) {
			// Iterar a través de los resultados y agregar cada identificador a la lista
			while (resultSet.next()) {
				ids.add(resultSet.getInt("id"));
			}
		}
		return ids;
	}
	
	public InfoValueObject getInfoByID(int id) throws SQLException {
		InfoValueObject infoVO = null;
		try (Connection connection = conn.getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM person WHERE id = ?")) {
			statement.setInt(1, id);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					// Creación de un objeto InfoValueObject con la información de la persona encontrada en el resultado
					infoVO = new InfoValueObject(resultSet.getInt("id"), resultSet.getString("name"),
							resultSet.getString("date_b"), resultSet.getString("date_d"),
							resultSet.getString("nationality"), resultSet.getString("occupation"),
							resultSet.getString("achievement"), resultSet.getString("description"),
							resultSet.getString("img"));
				}
			}
		}
		return infoVO;
	}

	// Se recupera los datos de una imagen de la base de datos dado su identificador
	public byte[] getImageData(int id) throws SQLException {
		byte[] imageData = null;
		try (Connection connection = conn.getConnection()) {
			String sql = "SELECT img FROM images WHERE id = ?";
			try (PreparedStatement stmt = connection.prepareStatement(sql)) {
				stmt.setInt(1, id);
				try (ResultSet resultSet = stmt.executeQuery()) {
					if (resultSet.next()) {
						// Se obtienen los datos de la imagen
						Blob blob = resultSet.getBlob("img");
						if (blob != null) {
							// Conversión del Blob a un array de bytes
							imageData = blob.getBytes(1, (int) blob.length());
						}
					}
				}
			}
		}
		return imageData;
	}	
	
	public List<String> getAllNationalities() throws SQLException {
	    List<String> nationalities = new ArrayList<>();
	    String sql = "SELECT DISTINCT nationality FROM PERSON";

	    try (Connection connection = conn.getConnection();
	         PreparedStatement stmt = connection.prepareStatement(sql);
	         ResultSet rs = stmt.executeQuery()) {
	        while (rs.next()) {
	            nationalities.add(rs.getString("nationality"));
	        }
	    }	
	    return nationalities;
	}
}
