package DAO;

import java.sql.Connection;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class TablasDAO {

    public static final Logger logger = LogManager.getLogger(TablasDAO.class);

    public static void crearTablasYPreCargarCursos(Connection conn) {
        try (Statement stmt = conn.createStatement()) {
            logger.info("Creando tablas y precargando cursos...");

            // Crear tabla cursos
            stmt.execute("CREATE TABLE IF NOT EXISTS cursos (" +
                    "codigo VARCHAR(10) PRIMARY KEY, " +
                    "nombre VARCHAR(255))");

            // Crear tabla alumnos
            stmt.execute("CREATE TABLE IF NOT EXISTS alumnos (" +
                    "id INT PRIMARY KEY, " +
                    "nombre VARCHAR(255))");

            // Insertar cursos predefinidos
            String[] cursosPredef = {
                    "('CS101', 'Programación Básica')",
                    "('CS102', 'Estructuras de Datos')",
                    "('CS103', 'Bases de Datos')"
            };
            for (String curso : cursosPredef) {
                stmt.execute("MERGE INTO cursos (codigo, nombre) KEY(codigo) VALUES " + curso);
                logger.debug("Curso insertado o actualizado: " + curso);
            }

            logger.info("Tablas creadas y cursos precargados correctamente.");

        } catch (Exception e) {
            logger.error("Error creando tablas o precargando cursos", e);
        }
    }
}

