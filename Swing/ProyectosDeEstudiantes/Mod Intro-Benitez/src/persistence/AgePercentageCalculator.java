package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

public class AgePercentageCalculator {

    private Connect conn;

    public AgePercentageCalculator(Connect conn) {
        this.conn = conn;
    }

    // Método para calcular el promedio de edad por nacionalidad
    public double calcAgePercentByNationality(String nationality) throws SQLException {
        double averageAge = 0.0;
        int person = 0;

        String sql = "SELECT date_b, date_d FROM PERSON WHERE nationality = ?";
        
        // Se hace uso de un bloque try-with-resources para garantizar el cierre automático de recursos JDBC
        try (Connection connection = conn.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nationality);
            try (ResultSet rs = stmt.executeQuery()) {
            	
            	// Calcula la edad de cada persona y las sumas
                while (rs.next()) {
                	// Obtiene la fecha de nacimiento del resultado y la convierte en LocalDate
                    LocalDate dateOfBirth = rs.getDate("date_b").toLocalDate(); 
                    // Obtiene la fecha de defunción, si existe, y se convierte en LocalDate Si no existe, establece la fecha actual
                    LocalDate dateOfDeath = rs.getDate("date_d") != null ? rs.getDate("date_d").toLocalDate() : LocalDate.now(); 
                    int age = calcAge(dateOfBirth, dateOfDeath); // se hace empleo del método calcAge
                    averageAge += age;
                    person++;
                }
            }
        }

        // Calcula el promedio solo si hay al menos una persona con esa nacionalidad
        double average = 0.0;
        if (person > 0) {
            average = averageAge / person;
        }

        return average;
    }

    // Método para calcular la edad en base a la fecha de nacimiento y la fecha de defunción
    private int calcAge(LocalDate dateOfBirth, LocalDate dateOfDeath) {
        return Period.between(dateOfBirth, dateOfDeath).getYears();
    }
}
