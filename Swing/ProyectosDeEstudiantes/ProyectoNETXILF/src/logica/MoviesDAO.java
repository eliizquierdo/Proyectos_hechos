package logica;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import persistencia.ConnectionMySQL;

/**
 * La clase `MoviesDAO` proporciona métodos para acceder y manipular datos de películas en la base de datos.
 */
public class MoviesDAO {

    private static Date releaseDate;

    /**
     * Inserta una película en la base de datos.
     *
     * @param movie La película a insertar.
     */
    public static void insertMovie(Programming movie) {
        Connection connection = null;
        try {
            connection = ConnectionMySQL.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (connection != null) {
            try {
                // Insertar en la tabla PROGRAMMING
                String sqlProgamming = "INSERT INTO PROGRAMMING (typeProgramming, nameProgramming, description, releaseDate, cover, gender, subGenre) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement statementProgramming = connection.prepareStatement(sqlProgamming,
                        Statement.RETURN_GENERATED_KEYS);

                java.sql.Date fechaSQL = new java.sql.Date(movie.getReleaseDate().getTime());
                statementProgramming.setString(1, movie.getTypeProgramming());
                statementProgramming.setString(2, movie.getProgrammingName());
                statementProgramming.setString(3, movie.getDescription());
                statementProgramming.setDate(4, fechaSQL);
                statementProgramming.setString(5, movie.getCover());
                statementProgramming.setString(6, movie.getGender());
                statementProgramming.setString(7, movie.getSubGenre());

                statementProgramming.executeUpdate();

                ResultSet generatedKeys = statementProgramming.getGeneratedKeys();
                int id_Prog = -1;
                if (generatedKeys.next()) {
                    id_Prog = generatedKeys.getInt(1);
                }

                // Insertar en la tabla MOVIES
                String sqlMovies = "INSERT INTO MOVIES (id_Programming) " + "VALUES (?)";

                PreparedStatement statementMovies = connection.prepareStatement(sqlMovies,
                        Statement.RETURN_GENERATED_KEYS);

                statementMovies.setInt(1, id_Prog);

                statementMovies.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al insertar datos en la tabla 'Programming': " + e.getMessage());
            }
        }
    }

    /**
     * Lista todas las películas almacenadas en la base de datos.
     *
     * @return Una lista de películas.
     */
    public static ListMovies listMovies() {
        ListMovies list = new ListMovies();

        Connection connection = null;

        try {
            connection = ConnectionMySQL.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (connection != null) {
            try {
                String sqlList = "SELECT * FROM PROGRAMMING WHERE typeProgramming = 'Pelicula'";

                PreparedStatement statement = connection.prepareStatement(sqlList);

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {

                    String typeProgramming = resultSet.getString("typeProgramming");
                    String nameProgramming = resultSet.getString("nameProgramming");
                    String description = resultSet.getString("description");
                    releaseDate = resultSet.getDate("releaseDate");
                    String cover = resultSet.getString("cover");
                    String gender = resultSet.getString("gender");
                    String subGenre = resultSet.getString("subGenre");

                    MoviesVO movie = new MoviesVO(typeProgramming, nameProgramming, description, cover, gender,
                            subGenre, releaseDate);
                    list.add(movie);

                }

            } catch (SQLException e) {
                System.err.println("Error al insertar datos en la tabla 'Clientes': " + e.getMessage());
            }
            return list;
        }
        return list;
    }

    /**
     * Elimina una programación de película de la base de datos.
     *
     * @param typeProgramming El tipo de programación.
     * @param nameProgramming El nombre de la programación.
     */
    public static void DeleteProgramming(String typeProgramming, String nameProgramming) {
        Connection connection = ConnectionMySQL.getConnection();

        // Primero, obtenemos el id_Persona de la programación
        String queryIdProgramming = "SELECT id_Programming FROM PROGRAMMING WHERE nameProgramming = ? AND typeProgramming = ?";

        try {
            PreparedStatement statementProgramming = connection.prepareStatement(queryIdProgramming);

            statementProgramming.setString(1, nameProgramming);
            statementProgramming.setString(2, typeProgramming);

            int id_Programming = -1;

            ResultSet resultSet = statementProgramming.executeQuery();
            if (resultSet.next()) {
                id_Programming = resultSet.getInt("id_Programming");
                System.out.println("id_Prog: " + id_Programming);
            } else {
                System.out.println("No se encontró un programa con los valores proporcionados.");
            }

            resultSet.close();
            statementProgramming.close();

            // Si encontramos el id_Persona, eliminamos los registros relacionados
            if (id_Programming != -1) {
                // Eliminar de PELICULAS
                String deleteMovie = "DELETE FROM MOVIES WHERE id_Programming = ?";
                PreparedStatement deleteMovies = connection.prepareStatement(deleteMovie);
                deleteMovies.setInt(1, id_Programming);
                deleteMovies.executeUpdate();
                deleteMovies.close();

                // Eliminar de PROGRAMACION
                String deleteProgramming = "DELETE FROM PROGRAMMING WHERE id_Programming = ?";
                PreparedStatement delProgramming = connection.prepareStatement(deleteProgramming);
                delProgramming.setInt(1, id_Programming);
                delProgramming.executeUpdate();
                delProgramming.close();

                JOptionPane.showMessageDialog(null, "Programacion eliminada correctamente.", "Exito",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Datos no validos, revisar.", "Error", JOptionPane.ERROR_MESSAGE);
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

    /**
     * Obtiene una película por su ID de programación.
     *
     * @param id_Programming El ID de programación de la película.
     * @return Una instancia de `MoviesVO` que representa la película encontrada.
     */
    public static MoviesVO getMovies(int id_Programming) {
        Connection connection = null;

        try {
            connection = ConnectionMySQL.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        MoviesVO movies = null;
        if (connection != null) {
            try {
                String sqlList = "SELECT * FROM PROGRAMMING JOIN MOVIES ON PROGRAMMING.id_Programming = MOVIES.id_Programming WHERE PROGRAMMING.id_Programming = ?;";

                PreparedStatement statement = connection.prepareStatement(sqlList);
                statement.setInt(1, id_Programming);

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {

                    String typeProgramming = resultSet.getString("typeProgramming");
                    String nameProgramming = resultSet.getString("nameProgramming");
                    String description = resultSet.getString("description");
                    releaseDate = resultSet.getDate("releaseDate");
                    String cover = resultSet.getString("cover");
                    String gender = resultSet.getString("gender");
                    String subGenre = resultSet.getString("subGenre");

                    movies = new MoviesVO(typeProgramming, nameProgramming, description, cover, gender,
                            subGenre, releaseDate);
                }

            } catch (SQLException e) {
                System.err.println("Error al insertar datos en la tabla 'Clientes': " + e.getMessage());
            }
            return movies;
        }
        return movies;
    }
}
