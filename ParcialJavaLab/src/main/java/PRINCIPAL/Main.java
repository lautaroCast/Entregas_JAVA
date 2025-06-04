package PRINCIPAL;
import DAO.TablasDAO;
import MODEL.Alumno;
import MODEL.Curso;
import UTIL.ConexionDB;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import static DAO.TablasDAO.logger;

public class Main {
    static Scanner entrada = new Scanner(System.in);
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer idAlumno=null;
        String nombreAlumno="";
        try (Connection conn = ConexionDB.conectar()) {

            // Crear tablas y precargar cursos
            TablasDAO.crearTablasYPreCargarCursos(conn);

            // Pedir datos Alumno
            logger.info("Inicio de carga de datos.");
            boolean continuar=true;
            while (continuar) {
                try {
                    System.out.println("Ingrese el dni del alumno:");
                    idAlumno = Integer.parseInt(entrada.nextLine());

                    System.out.println("Ingrese el nombre del alumno:");
                    nombreAlumno = entrada.nextLine();
                    if (!nombreAlumno.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s]+")) {
                        throw new IllegalArgumentException("El nombre contiene caracteres inválidos.");
                    }
                    logger.info("DATOS INGRESADOS CORRECTAMENTE");

                    continuar = false;
                    logger.info("Alumno registrado correctamente: " + nombreAlumno + " (DNI: " + idAlumno + ")");

                } catch (NumberFormatException e) {
                    logger.info("El DNI ingresado no es válido. Intente nuevamente.");
                } catch (IllegalArgumentException e) {
                    logger.info(e.getMessage());
                }
            }


            Alumno alumno = new Alumno(idAlumno, nombreAlumno);

            // Pedir código de curso y validar existencia
            String codigoCurso;
            while (true) {
                codigoCurso =JOptionPane.showInputDialog("Ingrese código del curso: ");

                PreparedStatement psCheck = conn.prepareStatement("SELECT COUNT(*) FROM cursos WHERE codigo = ?");
                psCheck.setString(1, codigoCurso);
                ResultSet rs = psCheck.executeQuery();
                rs.next();
                int count = rs.getInt(1);
                if (count > 0) {
                    break;  // Código válido
                } else {
                    logger.info("El código de curso no existe. Intente de nuevo.");

                }
            }

            // Obtener nombre del curso para mostrarlo
            PreparedStatement psCurso = conn.prepareStatement("SELECT nombre FROM cursos WHERE codigo = ?");
            psCurso.setString(1, codigoCurso);
            ResultSet rsCurso = psCurso.executeQuery();
            rsCurso.next();
            String nombreCurso = rsCurso.getString("nombre");

            Curso curso = new Curso(codigoCurso, nombreCurso);

            // Mostrar datos
            alumno.mostrarInfo();
            curso.mostrarInfo();

            // Insertar alumno
            PreparedStatement psAlumno = conn.prepareStatement("MERGE INTO alumnos (id, nombre) KEY(id) VALUES (?, ?)");
            psAlumno.setInt(1, alumno.getId());
            psAlumno.setString(2, alumno.getNombre());
            psAlumno.executeUpdate();

            logger.info("Datos guardados en la base.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}