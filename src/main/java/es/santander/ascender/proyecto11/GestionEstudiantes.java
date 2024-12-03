package es.santander.ascender.proyecto11;

import java.util.HashSet;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;

public class GestionEstudiantes implements IGestionEstudiantes {

    // Conjunto para almacenar los estudiantes
    private Set<String> estudiantes;
    // Mapa para asociar estudiantes con sus calificaciones
    private Map<String, Integer> calificaciones;

    // Constructor
    public GestionEstudiantes() {
        estudiantes = new HashSet<>();
        calificaciones = new HashMap<>();
    }

    // Agregar un estudiante y su calificación
    @Override
    public boolean agregarEstudiante(String nombre, int calificacion) {
        if (estudiantes.contains(nombre)) {
            return false; // Si ya existe el estudiante
        }
        estudiantes.add(nombre);
        calificaciones.put(nombre, calificacion);
        return true;
    }

    // Obtener la calificación de un estudiante
    @Override
    public Integer obtenerCalificacion(String nombre) {
        return calificaciones.get(nombre);
    }

    // Mostrar todos los estudiantes y sus calificaciones
    @Override
    public Map<String, Integer> obtenerEstudiantesYCalificaciones() {
        return new HashMap<>(calificaciones); // Retorna una copia del mapa
    }

    // Verificar si un estudiante existe en el conjunto
    @Override
    public boolean existeEstudiante(String nombre) {
        return estudiantes.contains(nombre);
    }

    // Eliminar un estudiante y su calificación
    @Override
    public boolean eliminarEstudiante(String nombre) {
        if (estudiantes.contains(nombre)) {
            estudiantes.remove(nombre);
            calificaciones.remove(nombre);
            return true;
        }
        return false;
    }

    // Método para agregar un conjunto de estudiantes (prueba en JUnit)
    @Override
    public void agregarEstudiantes(Set<String> nuevosEstudiantes, Map<String, Integer> nuevasCalificaciones) {
        for (String estudiante : nuevosEstudiantes) {
            estudiantes.add(estudiante);
            calificaciones.put(estudiante, nuevasCalificaciones.get(estudiante));
        }
    }
}
